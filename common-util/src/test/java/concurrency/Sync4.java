package concurrency;

/**
 * Created by pmz on 2017/9/24 18:54.
 */
public class Sync4 {
    public static void main(String[] args) {
        ThreadA2 a = new ThreadA2();
        a.setName("A");
        a.start();

        ThreadB2 b = new ThreadB2();
        b.setName("B");
        b.start();
    }
}
class Service2{
    public static void printA() {
        synchronized (Service2.class) {
            try {
                System.out.println("线程名称为：" + Thread.currentThread().getName()
                        + "在" + System.currentTimeMillis() + "进入printA");
                Thread.sleep(3000);
                System.out.println("线程名称为：" + Thread.currentThread().getName()
                        + "在" + System.currentTimeMillis() + "离开printA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void printB() {
        synchronized (Service2.class) {
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "进入printB");
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "离开printB");
        }
    }

}

class ThreadA2 extends Thread {
    @Override
    public void run() {
        Service2.printA();
    }

}

class ThreadB2 extends Thread {
    @Override
    public void run() {
        Service2.printB();
    }
}
