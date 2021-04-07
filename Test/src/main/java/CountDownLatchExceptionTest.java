import java.util.concurrent.CountDownLatch;

public class CountDownLatchExceptionTest {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("父线程开始执行");
        CountDownLatch countDownLatch = new CountDownLatch(2);

        try {

            new Thread(new TestThread(countDownLatch,1)).start();
            new Thread(new TestThread(countDownLatch,0)).start();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("异常。。。");
        }

        countDownLatch.await();

        System.out.println("父线程执行完毕");


    }


    static class TestThread implements Runnable {

        CountDownLatch countDownLatch;

        private int num;

        public TestThread(CountDownLatch countDownLatch, int num) {
            this.countDownLatch = countDownLatch;
            this.num = num;
        }

        @Override
        public void run() {
            try {
                System.out.println("进入了子线程。。。。");
                int a = 1 / num;
            } finally {
                countDownLatch.countDown();
            }
        }
    }

}
