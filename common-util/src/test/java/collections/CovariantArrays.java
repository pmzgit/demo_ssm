package collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pmz on 2018/5/2 8:33.
 * main 方法中的第一行，创建了一个 Apple 数组并把它赋给 Fruit 数组的引用。这是有意义的，Apple 是 Fruit 的子类，一个 Apple 对象也是一种 Fruit 对象，所以一个 Apple 数组也是一种 Fruit 的数组。这称作数组的协变，Java 把数组设计为协变的，对此是有争议的，有人认为这是一种缺陷。

 尽管 Apple[] 可以 “向上转型” 为 Fruit[]，但数组元素的实际类型还是 Apple，我们只能向数组中放入 Apple或者 Apple 的子类。在上面的代码中，向数组中放入了 Fruit 对象和 Orange 对象。对于编译器来说，这是可以通过编译的，但是在运行时期，JVM 能够知道数组的实际类型是 Apple[]，所以当其它对象加入数组的时候就会抛出异常。

 泛型设计的目的之一是要使这种运行时期的错误在编译期就能发现，看看用泛型容器类来代替数组会发生什么：
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }
        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }

    }

    @Test
    public void t1(){
//        ArrayList<Fruit> flist = new ArrayList<Apple>();
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error: can’t add any type of object:
//         flist.add(new Apple());
//         flist.add(new Fruit());
//         flist.add(new Object());
        flist.add(null); // Legal but uninteresting
        // We know that it returns at least Fruit:
        Fruit f = flist.get(0);
        System.out.println(f);
    }
    @Test
    public void t2(){
        List<? extends Fruit> flist =
                Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0); // No warning
        System.out.println(a);
        System.out.println(flist.contains(new Apple()));; // Argument is ‘Object’
        System.out.println(flist.indexOf(new Apple()));; // Argument is ‘Object’

        //flist.add(new Apple());   无法编译
    }
}

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}