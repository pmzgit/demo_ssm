package designpattern.adapter;

/**
 * Created by pmz on 2017/5/26 16:37.
 */
public class SourceSub2 extends AbstractWrapper{

    @Override
    public void method2(){
        System.out.println("the sourceable interface`s second sub21");
    }
}
