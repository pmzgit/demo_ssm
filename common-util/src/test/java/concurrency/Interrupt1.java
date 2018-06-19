package concurrency;

/**
 * Created by pmz on 2017/9/23 19:02.
 */
public class Interrupt1 {
    public static void main(String[] args) {
        try {
            MyThread1 myThread1 = new MyThread1();
            myThread1.start();
            Thread.sleep(1);
            myThread1.interrupt();
        }catch (InterruptedException ie){
            System.out.println("main catch");
            ie.printStackTrace();
        }
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}