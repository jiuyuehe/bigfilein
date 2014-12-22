import com.qycloud.oatos.bigfilein.service.LoginService;
import com.qycloud.oatos.bigfilein.service.UploadFileService;
import com.qycloud.oatos.bigfilein.utils.FileUtil;
import com.qycloud.oatos.bigfilein.utils.QuickMD5;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiuyuehe on 2014/11/1.
 */
public class ServiceTest {


    @Test
    public void testLogin() throws Exception {
        LoginService.login("18123936031", "111111");
        LoginService.getUserInfo();
        LoginService.getFiles();
    }

    @Test
    public void testFileBlock() throws Exception {
        File file = new File("C:\\Users\\jiuyuehe\\Desktop\\燕麦私有云介绍1.0.pptx");
//        FileInputStream fis = new FileInputStream(file);
//        byte [] buf = new byte[1024];
//        System.out.println("fileMD5"+QuickMD5.getFileMD5Buffer(file));
//        System.out.println("\"fileMD5\""+FileUtil.getFileMD5(file));
//        int red = 0;
//        while((red = fis.read(buf))>0){
//            System.out.println("q"+QuickMD5.getBufMd5(buf));
//            System.out.println("q"+QuickMD5.getMD5String(buf));
//            System.out.println("f"+FileUtil.getMD5(buf));
//        }
        // UploadFileService.sectionFileUpload(file);
    }

    @Test
    public void tesetMd5() throws Exception {
        File file = new File("‪E:/tools/VMware-workstation-full-9.0.2-1031769.exe");
        System.out.println(FileUtil.getFileMD5(file));
        System.out.println(QuickMD5.getFileMD5Channel(file));
        System.out.println(QuickMD5.getFileMD5Buffer(file));
    }

    @Test
    public void testBlockUpload() throws Exception {
        //File file = new File("C:\\Users\\jiuyuehe\\Desktop\\libgd.so.2.0.0");
//        File file = new File("C:\\Users\\jiuyuehe\\Desktop\\php.tar");
//        File file = new File("D:\\sucai\\bazar-wp-v2.2.2.zip");
        File file = new File("E:\\tools\\Photoshop_13_LS3.7z");


        UploadFileService.checkFile(QuickMD5.getFileMD5Channel(file), file.getName(), file.length());
        //   UploadFileService.checkFile();
    }

    @Test
    public void testSectionCheck() throws Exception {
//      File file = new File("C:\\Users\\jiuyuehe\\Desktop\\燕麦私有云介绍1.0.pptx");
        // File file = new File("C:\\Users\\jiuyuehe\\Desktop\\2014-11-29_115359.png");

        File file = new File("E:\\pac\\zip");
//       UploadFileService.checkFile(QuickMD5.getFileMD5Channel(file),file.getName(),file.length());
        // UploadFileService.defaultBlockSizeUpload(file);

//        UploadFileService.sectionFileUpload(file,1,1024,null);

        File[] files = file.listFiles();

        List<Thread> list = new ArrayList<Thread>();

        for (final File file1 : files) {
            Thread t1 = new Thread(file1.getName()) {
                @Override
                public void run() {
                    try {
                        UploadFileService.defaultBlockSizeUpload(file1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            t1.start();
            list.add(t1);
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).join();
        }
    }


}
