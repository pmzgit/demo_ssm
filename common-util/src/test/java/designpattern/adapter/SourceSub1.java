package designpattern.adapter;

/**
 * Created by pmz on 2017/5/26 16:35.
 */
public class SourceSub1 extends AbstractWrapper{
    @Override
    public void method1() {
        System.out.println("the sourceable interface`s first sub1");
    }


}
