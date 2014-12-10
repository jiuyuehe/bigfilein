package com.qycloud.oatos.bigfilein.service;

import com.qycloud.oatos.bigfilein.model.ImportFile;
import com.qycloud.oatos.bigfilein.utils.Constant;
import com.qycloud.oatos.bigfilein.utils.Logs;
import com.qycloud.oatos.bigfilein.utils.SQLiteDB;

import java.sql.*;
import java.util.List;

/**
 * Created by jiuyuehe on 2014/10/30.
 */
public class ImportDAO implements IDAO {


    @Override
    public int insertFile(ImportFile infile) {
        Connection conn = SQLiteDB.getConnection();
        int pk = -1;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Constant.insertSQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, infile.getName());
            ps.setInt(2, infile.getFileType());
            ps.setString(3, infile.getFilePath());
            ps.setLong(4, infile.getFileSize());
            ps.setInt(5, infile.getImported());
            ps.setString(6, infile.getLastModify());
            ps.setInt(7, infile.getPid());
            ps.execute();
            ResultSet rest = ps.getGeneratedKeys();
            rest.next();
            pk = rest.getInt(1);
            Logs.getLogger().info("insert file "+infile.getName()+"pk:"+pk);
        } catch (SQLException e) {
            e.printStackTrace();
            Logs.getLogger().error(e.getStackTrace());
            return pk;
        }
        SQLiteDB.close(conn);
        return pk;
    }

    @Override
    public ImportFile getFileById(int id, int pid) {
        return null;
    }

    @Override
    public int updateFile(int id) {
        Connection conn = SQLiteDB.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Constant.updateSql);
            ps.setInt(1, id);
            ps.execute();
            SQLiteDB.close(conn);
        }catch (SQLException e){
            return -1;
        }
            return 0;
    }

    @Override
    public List<ImportFile> getListFileByParentId(int pid) {

        Connection conn = SQLiteDB.getConnection();
        PreparedStatement ps = null;
       // List<ImportFile> l
        try {
            ps = conn.prepareStatement(Constant.getListSql);
            ps.setString(1,"pid");
            ps.setInt(2,pid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              //  rs.getInt();
            }

            SQLiteDB.close(conn);
        }catch (SQLException e){
            return null;
        }
        return null;
    }
}
