package generic;

import org.junit.Test;

/**
 * Created by pmz on 2017/5/18 11:11.
 * 如果P是S的超类，那么 Pair<S>就是Pair<? extends P>的子类型，通配符就是为了解决这个问题的。
 */
public class WildCardTest {

    @Test
    public void testExtends(){
        Parent<Integer> b1 = new Parent<Integer>();
        b1.setName(123);

        Parent<? extends Number> b2 = b1;
        Integer i = 1;
//        b2.setName(i);
        Number s = b2.getName();
//        Integer i1 = b2.getName();
        System.out.println(b2.getName());
    }

    @Test
    public void testSuper(){
        Parent<Number> parent = new Parent<Number>();
        parent.setName(123.4);

        Parent<? super Double> parent1 = parent;

        Double d = 22.3;
        parent1.setName(d);

//        Integer integer = parent1.getName();

        Object o = parent1.getName();
        System.out.println(o);
    }
}
