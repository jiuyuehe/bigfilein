package producerConsumer;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by jiuyuehe on 2014/12/13.
 */
public class FileEnumerTask implements  Runnable{

    public static File DUMMY =new File("");

    private BlockingQueue<File> queue;

    private File StaringDirectory;

    public FileEnumerTask(BlockingQueue<File> queue, File staringDirectory) {
        this.queue = queue;
        StaringDirectory = staringDirectory;
    }


    @Override
    public void run() {
        
    }
}
