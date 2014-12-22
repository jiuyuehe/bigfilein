package com.qycloud.oatos.bigfilein.model;

/**
 * Created by jiuyuehe on 2014/10/30.
 */
public class Constant {

    public static String IP;
    public static String userName = "mis xiao";
    public static String pwd;
    public static String UT;


    public static long ENT_ID = 828316001;
    public static long USER_ID = 828317001;
    public static long folderId = 828386001;


    public static final String Check_URL = "/os/node/upload/section/check/";
    public static final String SECTION_UPLOAD_URL = "/upload/section";


    public static final String ENT_FILE = "sharedisk";
    public static final String PERSONAL_FILE = "onlinedisk";
    public static final String UserTokenkey = "UT";
    public static final String file = "file";
    public static final String param = "param";


    public static final String LOGIN = "/os/java/pub/user/signin";
    public static final String GET_USER_INFO = "/os/java/sc/user/getUserInfo";
    public static final String GET_FILES = "/os/java/sc/file/getFiles";
    public static final String CREATE_FOLDER = "/os/java/sc/file/createFolder";

    public static final String ERROR_MARK = "error";

    public static String getUrl(String uriName) {

        return "http://" + Constant.IP + uriName;
    }


    /**
     * 创建表
     */
    public static String create_table = " create table if not exists bigfilein(" +
            " id integer primary key AUTOINCREMENT , name varchar(60), filetype int(1) ,filepath varchar(255),fileszie long, imported int(1),lastmodify varchar(20),  pid integer )";

    /**
     * 插入数据
     */
    public static String insertSQL = "insert into bigfilein values(null,?,?,?,?,?,?,?)";


    /**
     * 更新数据
     */
    public static String updateSql = "update bigfilein set imported =1 where id = ?";

    /**
     * 查找数据
     */
    public static String getListSql = "select * from bigfilein where ? = ?";


}
