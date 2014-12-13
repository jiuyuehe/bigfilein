package com.qycloud.oatos.bigfilein.model.loacldb;

/**
 * Created by jiuyuehe on 2014/10/30.
 */

public class ImportFile {

    private long id;

    private String name;

    // 文件夹 0， 文件1
    private int fileType;

    private String filePath;

    private long fileSize;

    private String lastModify;
    // 为导入0；已导入 1；
    private int imported;

    private int pid;

    private String md5;

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getFileType() {
        return fileType;
    }

    public int getImported() {
        return imported;
    }

    public int getPid() {
        return pid;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public long getId() {
        return id;
    }

    public String getLastModify() {
        return lastModify;
    }

    public String getName() {
        return name;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public void setImported(int imported) {
        this.imported = imported;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastModify(String lastModify) {
        this.lastModify = lastModify;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public  ImportFile(){

    }

    public ImportFile(long id, String name, int fileType, String filePath, long fileSize, String lastModify, int imported, int pid) {
        this.id = id;
        this.name = name;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.lastModify = lastModify;
        this.imported = imported;
        this.pid = pid;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

