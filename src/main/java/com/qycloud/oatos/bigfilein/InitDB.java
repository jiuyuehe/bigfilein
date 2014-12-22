package com.qycloud.oatos.bigfilein;

import com.qycloud.oatos.bigfilein.model.Constant;
import com.qycloud.oatos.bigfilein.utils.SQLiteDB;

/**
 * Created by jiuyuehe on 2014/10/30.
 */
public class InitDB {

    private String dbFilePath;


    public void CreateFileImportDB() {

    }

    public static void main(String[] args) {
        SQLiteDB.executeSchema(Constant.create_table);
    }


}
