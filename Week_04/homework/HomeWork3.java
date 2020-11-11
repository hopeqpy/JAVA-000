package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @program: JAVA-000
 * @description: 家庭作业
 * @author: qpy
 */
public class HomeWork3 {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        Boolean condition = false;
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        int result = getResult1();

        // 确保  拿到result 并输出
        System.out.println( "异步计算结果为：" + result );

        System.out.println( "使用时间：" + (System.currentTimeMillis() - start) + " ms" );

        // 然后退出main线程
    }

    private static int sum() {
        return fibo( 36 );
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo( a - 1 ) + fibo( a - 2 );
    }

    //方法1
    private static int getResult1() throws InterruptedException {
        Map<String, Integer> map = new HashMap();
        Thread thread = new Thread( () -> {
            Integer sum = sum();
            map.put( "result", sum );
        } );
        thread.start();
        thread.join();
        return map.get( "result" );
    }
    //方法2
    private static int getResult2() throws InterruptedException, ExecutionException {
        FutureTask<Integer> futureTask =new FutureTask( new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        return futureTask.get();
    }
    //方法3
    private static int getResult3() throws InterruptedException, ExecutionException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        class Task implements Runnable{
            private volatile int result;
            @Override
            public void run() {
                result=sum();
                countDownLatch.countDown();
            }

            public int getResult() {
                return result;
            }
        }
        Task task =new Task();
        Thread thread = new Thread(task);
        thread.start();
        countDownLatch.await();
        return task.result;
    }

    //方法4
    private static int getResult4() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture =CompletableFuture.supplyAsync(HomeWork3::sum );
        return completableFuture.get();
    }

    //方法5
    private static int getResult5() throws InterruptedException {
        class Task implements Runnable{
            public volatile boolean result =false;
            private volatile int sum ;
            @Override
            public void run() {
                sum=sum();
                result=true;
            }

            public int getResult() {
                return sum;
            }
        }
        Task task =new Task();
        Thread thread = new Thread(task);
        thread.start();
        while (!task.result){
            Thread.sleep( 1000 );
        }
        return task.sum;

    }

    //方法6
    private static int getResult6() throws InterruptedException {
        Semaphore semaphore =new Semaphore(  1);
        class Task extends Thread{
            public  Semaphore semaphore;
            private volatile int sum ;

            public Task(Semaphore semaphore){

            }

            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    sum=sum();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public int getResult() {
                return sum;
            }
        }
        Task task =new Task(semaphore);
        task.start();
        while (!semaphore.tryAcquire()){
            Thread.sleep( 1000 );
        }
        return task.sum;

    }

    //方法7
    private static int getResult7() throws InterruptedException {
        Map<String, Integer> map = new HashMap();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                map.put( "result", sum() );
            }
        });
        cyclicBarrier.wait();
        return map.get( "result" );

    }

    //方法8
    private static int getResult8() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletionService completionService = new ExecutorCompletionService<>(executorService);
        Future<Integer> task = completionService.submit(() -> sum());
        return task.get();

    }


}
