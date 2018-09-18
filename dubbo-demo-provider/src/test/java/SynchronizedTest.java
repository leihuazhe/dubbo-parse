/**
 * @author maple 2018.09.11 下午10:44
 */
public class SynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + ": 执行了run");
                    notify();
                }
            }
        };

        obj.wait();

        synchronized (t1) {
            t1.start();
            System.out.println(Thread.currentThread().getName() + " :开始执行");
            t1.wait();
            System.out.println(Thread.currentThread().getName() + " :END");

        }
    }
}
