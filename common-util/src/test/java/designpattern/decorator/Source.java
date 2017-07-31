package designpattern.decorator;


/**
 * Created by pmz on 2017/5/26 16:58.
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("the original method");
    }


}
