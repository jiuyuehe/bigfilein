package producerConsumer;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by jiuyuehe on 2014/12/13.
 */
public class BlockingQueueTest {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String directory = in.nextLine();

        String keyword = in.nextLine();


        BlockingQueue<File> queue =  new ArrayBlockingQueue<File>(10);




    }
}
