package com.qycloud.oatos.bigfilein;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

/**
 * Created by jiuyuehe on 2014/10/27.
 */
public class App {

    // TODO 需求

    /**
     * 文件从哪来 到哪去
     * 文件传多少剩多少，效率如何，速率如何，剩余时间多少
     * 就是传一半的时候，断网、死机、断电，导致软件重启，我要知道在什么地方断了
     * 日志记录
     */


    private String importPath;


    //TODO    文件分析；


    private void walkFileTree(String url) {
//        Path path = Paths.get(url);
//        SimpleFileVisitor sf = new SimpleFileVisitor();
//        Files.walkFileTree(path,)
    }


    //TODO    文件监控；


    //TODO  文件导入


}
