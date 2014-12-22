package com.qycloud.oatos.bigfilein.model.oatos;

/**
 * Created by jiuyuehe on 2014/12/22.
 */
public class CreateFolderParam {

    private Long parentId;

    private String name;

    private Long maxSize;

    private String fileType;


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
