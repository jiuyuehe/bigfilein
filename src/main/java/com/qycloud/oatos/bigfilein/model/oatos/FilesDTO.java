package com.qycloud.oatos.bigfilein.model.oatos;

import com.qycloud.oatos.bigfilein.model.oatos.BaseDTO;
import com.qycloud.oatos.bigfilein.model.oatos.FileNewDTO;

import java.util.List;


/**
 * 文件list
 *
 * @author yang
 */
public class FilesDTO extends BaseDTO {

    /**
     * 文件list
     */
    private List<FileNewDTO> files;

    /**
     * 结果总条数
     */
    private Integer resultCount;

    public FilesDTO() {
    }

    public List<FileNewDTO> getFiles() {
        return files;
    }

    public void setFiles(List<FileNewDTO> files) {
        this.files = files;
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

}
