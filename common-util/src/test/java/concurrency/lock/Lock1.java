package concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pmz on 2017/9/25 21:53.
 */
public class Lock1 {
    public static void main(String args[]) {
        Resource resource = new Resource();
        new Thread(new Producer(resource)).start();
        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}
class Resource {
    private int number = 0;//资源编号
    private boolean flag = false;//资源标记  时候有资源

    /* 创建一个锁对象。*/
    private Lock lock = new ReentrantLock();//锁
    /*通过已有的锁获取该锁上的监视器对象。通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者。*/
    private Condition condition_consumer = lock.newCondition();//消费者对锁的监视器
    private Condition condition_producer = lock.newCondition();//生产者对锁的监视器

    public void create() {
        lock.lock();
        try {
            while (flag) {
                condition_producer.await();
            }
            number++;
            System.out.println("生产者--------------" + number);
            flag = true;
            condition_consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void destroy() {
        lock.lock();
        try {
            while (!flag) {
                condition_consumer.await();
            }
            System.out.println("消费者***" + number);
            flag = false;
            condition_producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
class Producer implements Runnable {
    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.create();
        }
    }
}
class Consumer implements Runnable {
    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.destroy();
        }
    }
}