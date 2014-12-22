package com.qycloud.oatos.bigfilein.service;

import com.qycloud.oatos.bigfilein.model.loacl.ImportFile;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jiuyuehe on 2014/10/30.
 */
public interface IDAO {

    public int insertFile(ImportFile infile) throws SQLException;

    public ImportFile getFileById(int id, int pid);

    public int updateFile(int id);

    public List<ImportFile> getListFileByParentId(int pid);


}
