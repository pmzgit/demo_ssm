package designpattern.decorator;

import org.junit.Test;

/**
 * Created by pmz on 2017/5/26 17:02.
 */
public class DecoratorTest {

    @Test
    public void test(){
        Source source = new Source();
        Decorator decorator = new Decorator(source);
        decorator.method();
    }
}
