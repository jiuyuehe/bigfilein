package com.qycloud.oatos.bigfilein.model.oatos;

/**
 * Created by jiuyuehe on 2014/11/26.
 */
public class SectionUploadCheckDTO {

    public long userId;
    public String fileType;
    public long folderId;
    public String fileName;
    public String fileMd5;
    public long fileSize;

    public SectionUploadCheckDTO() {
    }

    public SectionUploadCheckDTO(long userId, String fileType, long folderId, String fileName, String fileMd5, long fileSize) {
        this.userId = userId;
        this.fileType = fileType;
        this.folderId = folderId;
        this.fileName = fileName;
        this.fileMd5 = fileMd5;
        this.fileSize = fileSize;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFolderId() {
        return folderId;
    }

    public void setFolderId(long folderId) {
        this.folderId = folderId;
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
}
