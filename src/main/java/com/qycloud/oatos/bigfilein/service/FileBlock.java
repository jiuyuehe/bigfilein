package com.qycloud.oatos.bigfilein.service;

import com.qycloud.oatos.bigfilein.model.oatos.Param;

/**
 * Created by jiuyuehe on 2014/10/31.
 */
public class FileBlock extends Param {

    private String fileName;
    private String fileMd5;
    private long fileSize;
    private int blockCount;
    private int blockIndex;
    private String blockMd5;
    private int blockSize;


    public FileBlock(String token, String fileType, long folderId, long userId) {
        super(token, fileType, folderId, userId);
    }

    public FileBlock(String token, String fileType, long folderId, long userId, String fileName, String fileMd5, long fileSize, int blockCount, int blockIndex, String blockMd5, int blockSize) {
        super(token, fileType, folderId, userId);
        this.fileName = fileName;
        this.fileMd5 = fileMd5;
        this.fileSize = fileSize;
        this.blockCount = blockCount;
        this.blockIndex = blockIndex;
        this.blockMd5 = blockMd5;
        this.blockSize = blockSize;
    }

    public FileBlock(){

    }



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public int getBlockIndex() {
        return blockIndex;
    }

    public void setBlockIndex(int blockIndex) {
        this.blockIndex = blockIndex;
    }

    public String getBlockMd5() {
        return blockMd5;
    }

    public void setBlockMd5(String blockMd5) {
        this.blockMd5 = blockMd5;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }


    @Override
    public String toString() {
        return "FileBlock{" +
                "fileName='" + fileName + '\'' +
                ", fileMd5='" + fileMd5 + '\'' +
                ", fileSize=" + fileSize +
                ", blockCount=" + blockCount +
                ", blockIndex=" + blockIndex +
                ", blockMd5='" + blockMd5 + '\'' +
                ", blockSize=" + blockSize +
                '}';
    }
}
