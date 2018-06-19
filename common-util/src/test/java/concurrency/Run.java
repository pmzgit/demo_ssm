package concurrency;

/**
 * Created by pmz on 2017/9/23 17:56.
 * 线程不安全
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread,"a");
        Thread b = new Thread(myThread,"b");
        Thread c = new Thread(myThread,"c");
        Thread d = new Thread(myThread,"d");
        a.start();
        b.start();
        c.start();
        d.start();
    }
}

class MyThread extends Thread{
    private int count = 5;

    @Override
    public void run() {
        count --;
        System.out.println("由" + Thread.currentThread().getName() + "  计算,count=" + count);
    }
}