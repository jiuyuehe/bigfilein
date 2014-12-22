package producerConsumer;

import com.qycloud.oatos.bigfilein.biz.ImportFileConsumer;
import com.qycloud.oatos.bigfilein.biz.ImportFileProducer;
import com.qycloud.oatos.bigfilein.model.loacl.ImportFile;

import java.util.concurrent.*;

/**
 * Created by jiuyuehe on 2014/12/13.
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws Exception {

        BlockingQueue<ImportFile> importFilesQueue = new LinkedBlockingQueue<ImportFile>(300);
        BlockingQueue<ImportFile> uploadFilesQueue = new LinkedBlockingQueue<ImportFile>(300);

        ImportFileProducer ip = new ImportFileProducer(importFilesQueue);

        ImportFileConsumer  qc = new ImportFileConsumer (importFilesQueue,uploadFilesQueue);
       // ImportFileConsumer  qc2 = new ImportFileConsumer (importFilesQueue,uploadFilesQueue);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(ip);
        pool.execute(qc);
       // pool.execute(qc2);
        pool.shutdown();
    }
}
