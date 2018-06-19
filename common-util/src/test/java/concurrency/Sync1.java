package concurrency;

import javax.naming.InterruptedNamingException;


public class Sync1 {
    public static void main(String[] args) {
        /**
         * Created by pmz on 2017/9/24 17:59.
         * 实验结论：两个线程访问同一个对象中的同步方法是一定是线程安全的。本实现由于是同步访问，所以先打印出a，然后打印出b

         这里线程获取的是HasPrivateNum的对象实例的锁——对象锁。
         */
        /*HasPrivateNum numRef = new HasPrivateNum();

        THa athread = new THa(numRef);
        athread.start();

        THb bthread = new THb(numRef);
        bthread.start();*/
        /**
         * 这里是非同步的，因为线程athread获得是numRef1的对象锁，而bthread线程获取的是numRef2的对象锁，他们并没有在获取锁上有竞争关系，因此，出现非同步的结果
         这里插播一下：同步不具有继承性
         */
        HasPrivateNum numRef1 = new HasPrivateNum();
        HasPrivateNum numRef2 = new HasPrivateNum();

        THa athread = new THa(numRef1);
        athread.start();

        THb bthread = new THb(numRef2);
        bthread.start();

    }
}
class HasPrivateNum{
    private int num = 0;

    synchronized public void add(String un){
        try {
            if (un.equals("a")){
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(un + " num=" + num);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

    }

}


class THa extends Thread{
    private HasPrivateNum numRef;
    public THa(HasPrivateNum numRef){
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.add("a");
    }
}

class THb extends Thread{
    private HasPrivateNum numRef;
    public THb(HasPrivateNum numRef){
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.add("b");
    }
}