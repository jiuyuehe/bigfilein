package com.qycloud.oatos.bigfilein.utils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.io.File;
import java.sql.*;
import java.util.Date;


/**
 * Created by jiuyuehe on 2014/10/27.
 */

public class SQLiteDB {

    private static String dir = "D:\\work";
    private static String dburl = null;
    private static Connection con = null;

    static {
        try {
           // String file = SQLiteDB.class.getProtectionDomain().getCodeSource().getLocation().getPath();
          //  String dir = file.substring(0, file.lastIndexOf("/"));
            dburl = "jdbc:sqlite:" + dir + "/oatos_import.db";
            Logs.getLogger().info(dburl);

            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) {
            Logs.getLogger().error("load db driver", ex);
        }
    }


    public static Connection getConnection(){
        if(con == null){
            try {
                con = DriverManager.getConnection(dburl);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return con;
        }
        return con;
    }

    public  static void close(Connection conn){
        try {
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建库，表,插入，更新数据；
     * @param sql
     * @return
     */
    public static int executeSchema(String sql ){
        Connection connection = getConnection();
        Statement statement;
        int result =-1;
        try {
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            result= statement.executeUpdate(sql);
            close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



    public static void main(String [] args){
//        String sql ="create table test2 (id integer primary key AUTOINCREMENT, name varchar)";
//        int re = SQLiteDB.executeSchema(sql);
//        System.out.println(re);

        String insert = "insert into test2 values('jack')";
        int re1 = SQLiteDB.executeSchema(insert);
        System.out.println(re1);
    }

}
