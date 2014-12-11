package com.qycloud.oatos.bigfilein.view;

/**
 * Created by jiuyuehe on 2014/12/11.
 */
public class FileAnalysisModel {

    private String scanning;

    private String failed;

    private int fileCount;

    private int folderCount;

    private int bigFileCount;

    private String countSize;

    public String getScanning() {
        return scanning;
    }

    public void setScanning(String scanning) {
        this.scanning = scanning;
    }

    public String getFailed() {
        return failed;
    }

    public void setFailed(String failed) {
        this.failed = failed;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public int getFolderCount() {
        return folderCount;
    }

    public void setFolderCount(int folderCount) {
        this.folderCount = folderCount;
    }

    public int getBigFileCount() {
        return bigFileCount;
    }

    public void setBigFileCount(int bigFileCount) {
        this.bigFileCount = bigFileCount;
    }

    public String getCountSize() {
        return countSize;
    }

    public void setCountSize(String countSize) {
        this.countSize = countSize;
    }
}
