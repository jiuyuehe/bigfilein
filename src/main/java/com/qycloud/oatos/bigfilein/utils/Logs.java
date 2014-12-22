package com.qycloud.oatos.bigfilein.utils;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * log
 *
 * @author yang
 */
public class Logs {

    static {
        PropertyConfigurator.configure(Logs.class.getClassLoader().getResource("log4j.properties"));
    }

    public static Logger getLogger() {
        return Logger.getLogger("import");
    }

}

