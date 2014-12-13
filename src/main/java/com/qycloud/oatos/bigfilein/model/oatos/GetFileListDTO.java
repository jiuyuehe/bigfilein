package com.qycloud.oatos.bigfilein.model.oatos;

/**
 * Created by jiuyuehe on 2014/12/9.
 */
public class GetFileListDTO {

    public String fileType;
    public String folderId;
    public int skipResults;
    public int maxResults;


    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public int getSkipResults() {
        return skipResults;
    }

    public void setSkipResults(int skipResults) {
        this.skipResults = skipResults;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }
}
