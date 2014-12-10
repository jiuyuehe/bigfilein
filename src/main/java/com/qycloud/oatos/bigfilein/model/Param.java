package com.qycloud.oatos.bigfilein.model;

/**
 * Created by jiuyuehe on 2014/10/31.
 */
public class Param {

    private String token;
    private String fileType;
    private long folderId;
    private long userId;

    public Param() {
    }

    public Param(String token, String fileType, long folderId, long userId) {
        this.token = token;
        this.fileType = fileType;
        this.folderId = folderId;
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public String getFileType() {
        return fileType;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }
}
