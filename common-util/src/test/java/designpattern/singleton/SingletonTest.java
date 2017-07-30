package designpattern.singleton;

import org.junit.Test;

/**
 * Created by pmz on 2017/5/25 11:40.
 */
public class SingletonTest {

    @Test
    public void testCanbeNull(){
        Singleton a = Singleton.getInstance();
        System.out.println(a);
    }

    @Test
    public void testPerfect(){
        SingletonThread a = SingletonThread.getInstance();
        System.out.println(a);
    }

    @Test
    public void testJvm(){
        SingletonJVM a = SingletonJVM.getInstance();
        System.out.println(a);
    }
}
