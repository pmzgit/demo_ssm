package concurrency;

/**
 * Created by pmz on 2017/9/23 18:18.
 */
public class GetName {
    public static void main(String[] args) {
        ChildThread ch = new ChildThread();
        Thread thread0 = new Thread(ch,"a");
        Thread thread1 = new Thread(ch,"b");
        Thread thread2 = new Thread(ch,"c");
        thread0.start();
        thread1.start();
        thread2.start();
    }

}

class ChildThread extends Thread{
    public ChildThread(){
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("run---end");
    }

}