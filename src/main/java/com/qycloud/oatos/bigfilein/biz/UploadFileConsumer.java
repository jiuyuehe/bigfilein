package com.qycloud.oatos.bigfilein.biz;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiuyuehe on 2014/12/13.
 */
public class UploadFileConsumer implements Runnable {

    private BlockingQueue uploadQueue;

    public UploadFileConsumer(BlockingQueue queue) {

        this.uploadQueue = queue;
    }

    @Override
    public void run() {
        System.out.println("启动上传线程");

        boolean isRunning = true;

        int flag = 0;

        while (isRunning) {
            System.out.println("get data for queue ..");
            Object data = null;
            try {
                data = uploadQueue.poll(2, TimeUnit.SECONDS);
                System.out.println("is consumer ... " + data);
                if (data == null) {
                    flag++;
                } else {
                    flag = 0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } finally {
                if (flag > 10) {
                    isRunning = false;
                }
                System.out.println("out consumer thread ..");
            }

        }

    }
}
