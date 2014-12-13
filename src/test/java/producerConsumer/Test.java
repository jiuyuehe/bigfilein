package producerConsumer;

/**
 * Created by jiuyuehe on 2014/12/13.
 */
public class Test {

    public static void main(String[] args) {

        StackBasket s = new StackBasket();
        Producer p = new Producer(s);
        Consumer c = new Consumer(s);

        Thread tp = new Thread(p);
        Thread tc = new Thread(c);
        tp.start();
        tc.start();

    }
}
