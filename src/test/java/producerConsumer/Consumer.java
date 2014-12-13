package producerConsumer;

/**
 * Created by jiuyuehe on 2014/12/13.
 */
public class Consumer implements Runnable {

    StackBasket ss = new StackBasket();

    public Consumer(StackBasket ss) {
        this.ss = ss;
    }

    @Override
    public void run() {

        for (int i = 0; i < 200; i++) {
            Mantou m = ss.pop();
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
