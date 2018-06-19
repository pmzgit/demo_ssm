package concurrency;

/**
 * Created by pmz on 2017/9/24 18:33.
 */
public class Sync3 {
    public static void main(String[] args) {
        // 两个线程在争夺同一个类锁，因此同步
       /* ThreadA1 a = new ThreadA1();
        a.setName("a1");
        a.start();
        ThreadA3 a3 = new ThreadA3();
        a3.setName("a3");
        a3.start();*/



        ThreadA1 c = new ThreadA1();
        c.setName("C");
        c.start();
        Service1 service1 = new Service1();
        ThreadB1 b = new ThreadB1(new Service1());
        b.setName("B");
        b.start();
        ThreadB1 d = new ThreadB1(new Service1());
        d.setName("D");
        d.start();
    }

}
class Service1 {

    synchronized public static void printA() {
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
    synchronized public static void printC() {
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
    synchronized public void printB() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "进入printB");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "离开printB");
    }
    synchronized public void printD() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "离开printB");
    }

}

class ThreadA1 extends Thread {
    @Override
    public void run() {
        Service1.printA();
    }

}
class ThreadA3 extends Thread {
    @Override
    public void run() {
        Service1.printC();
    }

}

class ThreadB1 extends Thread {
    Service1 service1 ;
    public ThreadB1(Service1 service){
        service1 = service;
    }
    @Override
    public void run() {
        service1.printB();
    }
}
