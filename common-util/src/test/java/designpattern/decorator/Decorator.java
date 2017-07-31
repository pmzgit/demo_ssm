package designpattern.decorator;


/**
 * Created by pmz on 2017/5/26 16:50.
 */
public class Decorator implements Sourceable{
//    private Source source;
    private Sourceable source;

    public Decorator(Sourceable source){
        super();
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
