package designpattern.adapter;

/**
 * Created by pmz on 2017/5/26 16:19.
 */
public class Adapter extends Source implements Targetable{

    @Override
    public void method2() {
        System.out.println("this is the targetable method");
    }
}
