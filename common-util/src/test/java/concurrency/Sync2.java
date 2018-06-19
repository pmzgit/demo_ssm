package concurrency;

/**
 * Created by pmz on 2017/9/24 18:27.
 * 如果对象实例A，线程1获得了对象A的对象锁，那么其他线程就不能进入需要获得对象实例A的对象锁才能访问的同步代码（包括同步方法和同步块）。不理解可以细细品味一下！
 */
public class Sync2 {
    public static void main(String[] args) {
        Service service = new Service("xiaobaoge");

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}

class Service {

    String anyString = new String();

    public Service(String anyString){
        this.anyString = anyString;
    }

    public void setUsernamePassword(String username, String password) {
        try {
            synchronized (anyString) {
                System.out.println("线程名称为：" + Thread.currentThread().getName()
                        + "在" + System.currentTimeMillis() + "进入同步块");
                Thread.sleep(3000);
                System.out.println("线程名称为：" + Thread.currentThread().getName()
                        + "在" + System.currentTimeMillis() + "离开同步块");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("a", "aa");

    }

}

class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("b", "bb");

    }

}