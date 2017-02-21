package theadlocal;

import java.util.Random;

/**
 * Created by Administrator on 2017/1/5.
 */
public class ThreadLocalDemo implements Runnable {


    private final static ThreadLocal<People> threadLocal = new ThreadLocal<People>();

    public static void main(String[] agrs) {
        ThreadLocalDemo td = new ThreadLocalDemo();
        Thread t1 = new Thread(td);
        Thread t2 = new Thread(td);
        t1.start();
        t2.start();
    }

    public void run() {
        accessStudent();
    }

    public void accessStudent() {
        // 获取当前线程的名字
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running!");
        // 产生一个随机数并打印
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println("concurrency " + currentThreadName + " set age to:" + age);
        People people = getPeople();
        people.setAge(age);
        System.out.println("concurrency " + currentThreadName + " first read age is:"
                + people.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("concurrency " + currentThreadName + " second read age is:"
                + people.getAge());
    }

    protected People getPeople() {
        People people = threadLocal.get();
        // 线程首次执行此方法的时候，threadLocal.get()肯定为null
        if (people == null) {
            // 创建一个对象，并保存到本地线程变量threadLocal中
            people = new People();
            threadLocal.set(people);
        }
        return people;
    }
}
