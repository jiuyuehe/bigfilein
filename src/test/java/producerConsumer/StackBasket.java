package producerConsumer;

/**
 * Created by jiuyuehe on 2014/12/13.
 */
public class StackBasket {

    Mantou sm[] = new Mantou[100];

    int index  = 0;


    public synchronized  void   push(Mantou mantou)   {
        try {
            while (index == sm.length){
                System.out.println("over 100 mantou");
                this.wait();
            }
            this.notify();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        sm[index] = mantou;

        index ++;

        System.out.println("生产了：" + mantou + " 共" + index + "个馒头");

    }

    public synchronized Mantou pop(){
        while (index <=10){
            System.out.println("馒头吃完了");

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();

        index -=10;

        System.out.println("消费了：---------" + sm[index] + " 共" + index + "个馒头");

        return sm[index];
    }



}
