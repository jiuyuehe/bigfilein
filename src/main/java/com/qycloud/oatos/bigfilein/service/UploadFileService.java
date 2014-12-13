package com.qycloud.oatos.bigfilein.service;

import com.qycloud.oatos.bigfilein.model.Constant;
import com.qycloud.oatos.bigfilein.model.oatos.CheckResult;
import com.qycloud.oatos.bigfilein.model.oatos.FileNewDTO;
import com.qycloud.oatos.bigfilein.model.oatos.SectionUploadCheckDTO;
import com.qycloud.oatos.bigfilein.utils.*;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by jiuyuehe on 2014/10/31.
 */

public class UploadFileService {
    /**
     * 检查文件上传的状态
     * @param fileMd5
     * @param fileName
     * @param fileSize
     *
     * 没有传输过的文件返回 ： {"statusCode":"OK","content":1}；
     * 没完全上传成功的返回 {"statusCode":"OK","content":3}；
     * 传输完成的返回 FileNewDTO
     *
     * 返回错误：{"statusCode":"errorSameFile","error":"check file upload fail!"}
     *
     */
    public static String checkFile(String fileMd5,String fileName,long fileSize)  {

        SectionUploadCheckDTO sectionUploadCheckDTO = new SectionUploadCheckDTO();
        sectionUploadCheckDTO.setUserId(Constant.USER_ID);
        sectionUploadCheckDTO.setFileMd5(fileMd5);
        sectionUploadCheckDTO.setFileName(fileName);
        sectionUploadCheckDTO.setFileSize(fileSize);
        sectionUploadCheckDTO.setFileType(Constant.ENT_FILE);
        sectionUploadCheckDTO.setFolderId(Constant.folderId);
        String param = null;
        String re = "";
        try {
            param = Json.toJson(sectionUploadCheckDTO);
             re =  XhrProxy.post(Constant.Check_URL,Constant.UT,param);
            System.out.println(re);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return re;
    }

    /**
     * 返回数组解析： arr【0】 = 文件分块数，arr【1】=  正好0； 有余1； arr[2]: 最后一块的大小；
     * @param fileSize
     * @param blockSize
     * @return
     */
    private static Integer[]  getBlockCount2Arr(long fileSize, long blockSize) {
        Integer [] arr = new Integer[3];

        if(fileSize<blockSize){
            arr[0] = 1;
            arr[1] = 1;
            arr[2] = (int)fileSize;
            return arr;
        }
        if(fileSize%blockSize == 0){
            arr[0] = (int)(fileSize/blockSize);
            arr[1] = 0;
            arr[2] = 0;
            return arr;
        }else{
            arr[0] = (int)((fileSize/blockSize)+1);
            arr[1] = 1;
            arr[2] = (int)(fileSize -(( fileSize/blockSize )*blockSize));
            return arr;
        }
    }

    public static void defaultBlockSizeUpload(File file) throws Exception{

      //  String fileMd5 = QuickMD5.getFileMD5Channel(file);
        String fileMd5 = FileUtil.getFileMD5(file);
        String fileName = file.getName();
        long fileSize = file.length();

        String re = checkFile(fileMd5, fileName, fileSize);

        FileNewDTO fileNewDTO = null;

        if(re.contains("content")){
            System.out.println("没有传输完成");
            CheckResult cr =  Json.parse(re, CheckResult.class);
            System.out.println(cr);
            int  blockSize =  getDefaultBlockSize(fileSize);
            sectionFileUpload(file,cr.getContent(),blockSize,fileMd5);
        }else if(re.contains("\"error\":")){
            System.out.println("有错误");
            CheckResult cr =  Json.parse(re, CheckResult.class);
            System.out.println(cr);

        }else{
            System.out.println("传输完成");
           // fileNewDTO =  Json.parse(re, FileNewDTO.class);
        }

    }

    private static int  getDefaultBlockSize(long fileSize) {

        long minSmall = 1024*1024*10;
        long small = 1024*1024*100;
        long medium= 1024*1024*500;
        //long big = 1024*1024*1024;
        if(fileSize<=minSmall){
            return 3*1024*1024;
        }else if(fileSize<=small){
            return 8*1024*1024;
        }else if(fileSize<=medium){
            return 16*1024*1024;
        }else{
            return 20*1024*1024;
        }
      //  return 1024;
    }

    /**
     * 分块上传2
     * @param file
     * @param blockIndex
     */
   public static void  sectionFileUpload(File file, int blockIndex, int blockSize,String fileMd5) throws Exception{

       if(fileMd5 ==null){
           fileMd5 =  QuickMD5.getFileMD5Channel(file);
       }

      // String fileMd5 = QuickMD5.getFileMD5Channel(file);
       String fileName = file.getName();
       long fileSize = file.length();

      // checkFile(fileMd5, fileName, fileSize);

       Integer [] arr = getBlockCount2Arr(fileSize, blockSize);

       int blockCount = arr[0];

       FileInputStream fis = new FileInputStream(file);

       fis.skip((blockIndex-1)*blockSize);

       //String token, String fileType, long folderId, long userId

       FileBlock fileBlock = new FileBlock(Constant.UT,Constant.ENT_FILE,Constant.folderId,Constant.USER_ID);
       fileBlock.setFileMd5(fileMd5);
       fileBlock.setBlockCount(blockCount);
       fileBlock.setFileName(fileName);
       fileBlock.setFileSize(fileSize);

       for (int i = (blockIndex-1); i < blockCount; i++) {
           byte[]  by = null;

           if((arr[1] ==1)&&(arr[0]-i ==1)){
               by = new byte[arr[2]];
               fileBlock.setBlockSize(arr[2]);
           }

           by = new byte[blockSize];
           fileBlock.setBlockSize(blockSize);

           int red = fis.read(by);

           fileBlock.setBlockMd5(QuickMD5.getBufMd5(by));
           fileBlock.setBlockIndex(blockIndex);
           System.out.println(Json.toJson(fileBlock));

          String res =  httpPost(fileName, fileBlock, by);

           blockIndex++;

           if((blockIndex-1) == blockCount){
               System.out.println("the last block, success");
               FileNewDTO  fileNewDTO =  Json.parse(res, FileNewDTO.class);
           }else{
               System.out.println(Thread.currentThread().getName() + "-->当前第："+(blockIndex-1)+"块" + "剩余 "+(blockCount-(blockIndex-1)));
           }
       }
   }



    private static String httpPost(String fileName, FileBlock fileBlock, byte[] by) {
        String res =null;
        try {
            String param = Json.toJson(fileBlock);
        HttpEntity reqEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .setCharset(Charset.forName("UTF-8"))
                .addTextBody("param", param, ContentType.APPLICATION_JSON)
                   .addBinaryBody("file", by, ContentType.APPLICATION_OCTET_STREAM, fileName)
               // .addPart("file", new ByteArrayBody(by, ContentType.DEFAULT_BINARY, fileName))
                .build();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("UT", Constant.UT);
        res = XhrProxy.post(Constant.SECTION_UPLOAD_URL, reqEntity, headers);

        System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
