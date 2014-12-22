package com.qycloud.oatos.bigfilein.biz;

import com.qycloud.oatos.bigfilein.model.loacl.ImportFile;
import com.qycloud.oatos.bigfilein.service.IDAO;
import com.qycloud.oatos.bigfilein.service.ImportDAO;
import com.qycloud.oatos.bigfilein.utils.Logs;

import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiuyuehe on 2014/12/13.
 * 将文件夹内的数据分析后，将文件写入数据库，同时将数据放入上传队列；
 */
public class ImportFileConsumer implements Runnable {

    private BlockingQueue importQueue;
    private BlockingQueue uploadQueue;

    public ImportFileConsumer(BlockingQueue importQueue, BlockingQueue uploadQueue) {

        this.importQueue = importQueue;
        this.uploadQueue = uploadQueue;
    }

    @Override
    public void run() {
        System.out.println("本地数据库线程启动。。。 | 上传生成这线程启动。。。");

        boolean isRunning = true;
        int flag = 0;
        while (isRunning) {
            ImportFile  data = null;

            try {
                    data = (ImportFile)importQueue.poll(2, TimeUnit.SECONDS);

                if (data != null) {
                    //TODO 写入数据
                    IDAO dao = new ImportDAO();
                    if( dao.insertFile(data) > 0){
                        Logs.getLogger().info("记录本地数据库成功！");
                    }else{
                        Logs.getLogger().error("记录本地数据库失败！");
                        System.err.println("记录本地数据库失败！");
                    }
                    // TODO 放入上传队列
                    uploadQueue.offer(data,100,TimeUnit.MILLISECONDS);
                    flag = 0;

                    Thread.sleep(1000);

                } else {
                    flag++;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }  catch (SQLException ex) {
                ex.printStackTrace();

            }finally {
                if (flag > 10) {
                    isRunning = false;
                }
            }
        }
        System.out.println("线程退出！");

    }
}
