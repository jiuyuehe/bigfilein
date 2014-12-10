import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by jiuyuehe on 2014/11/14.
 */
public class TestForkJoin extends RecursiveTask<Integer>{

    public static final  int taskNum = 5;

    private int start;

    private  int end;


    public TestForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= taskNum;

        if(canCompute){
            for (int i = start; i<=end ;i++){
                sum +=i;
            }
        }else{
            int middle = (start+end)/2;
            TestForkJoin leftTask = new TestForkJoin(start,middle);
            TestForkJoin rightTask = new TestForkJoin(middle+1,end);

            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();

            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult  + rightResult;

        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool =new ForkJoinPool();

        TestForkJoin task =  new TestForkJoin(1,100000);

        Future<Integer> re = forkJoinPool.submit(task);

      //  System.out.println(500_00);

        try {
            System.out.println(re.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
