package concurrency;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pmz on 2017/2/28 17:28.
 * ConcurrentHashMap的简要总结：

 1、public V get(Object key)不涉及到锁，也就是说获得对象时没有使用锁；

 2、put、remove方法要使用锁，但并不一定有锁争用，原因在于ConcurrentHashMap将缓存的变量分到多个Segment，每个Segment上有一个锁，只要多个线程访问的不是一个Segment就没有锁争用，就没有堵塞，各线程用各自的锁，ConcurrentHashMap缺省情况下生成16个Segment，也就是允许16个线程并发的更新而尽量没有锁争用；

 3、Iterator对象的使用，不一定是和其它更新线程同步，获得的对象可能是更新前的对象，ConcurrentHashMap允许一边更新、一边遍历，也就是说在Iterator对象遍历的时候，ConcurrentHashMap也可以进行remove,put操作，且遍历的数据会随着remove,put操作产出变化，所以希望遍历到当前全部数据的话，要么以ConcurrentHashMap变量为锁进行同步(synchronized该变量)，要么使用CopiedIterator包装iterator，使其拷贝当前集合的全部数据，但是这样生成的iterator不可以进行remove操作。



 Hashtable和ConcurrentHashMap的不同点：

 1、Hashtable对get,put,remove都使用了同步操作，它的同步级别是正对Hashtable来进行同步的，也就是说如果有线程正在遍历集合，其他的线程就暂时不能使用该集合了，这样无疑就很容易对性能和吞吐量造成影响，从而形成单点。而ConcurrentHashMap则不同，它只对put,remove操作使用了同步操作，get操作并不影响，详情请看以上第1,2点，当前ConcurrentHashMap这样的做法对一些线程要求很严格的程序来说，还是有所欠缺的，对应这样的程序来说，如果不考虑性能和吞吐量问题的话，个人觉得使用Hashtable还是比较合适的；

 2、Hashtable在使用iterator遍历的时候，如果其他线程，包括本线程对Hashtable进行了put，remove等更新操作的话，就会抛出ConcurrentModificationException异常，但如果使用ConcurrentHashMap的话，就不用考虑这方面的问题了，详情请看以上第3点；
 */
public class ConcurrentHashMapTest {
    static Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
    @Test
    public void test1() throws InterruptedException {

            for (long i = 0; i < 5; i++) {
                conMap.put(i, i + "");
            }

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    conMap.put(100l, "100");
                    System.out.println("ADD:" + 100);
                }

            });
            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    for (Iterator<Map.Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext();) {
                        Map.Entry<Long, String> entry = iterator.next();
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        thread.start();
        thread2.start();

            Thread.sleep(3000);
            System.out.println("--------");
            for (Map.Entry<Long, String> entry : conMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }


    }
}
