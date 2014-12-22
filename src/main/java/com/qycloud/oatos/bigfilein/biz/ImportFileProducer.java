package com.qycloud.oatos.bigfilein.biz;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;


/**
 * Created by jiuyuehe on 2014/12/12.
 */
public class ImportFileProducer implements Runnable {


    private BlockingQueue queue;

    public ImportFileProducer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Files.walkFileTree(Paths.get("E:\\java8\\javafx-src"), new ImportFileAccess(queue));

            System.out.println("------------------over--------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
