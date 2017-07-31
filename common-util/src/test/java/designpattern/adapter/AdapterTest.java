package designpattern.adapter;

import org.junit.Test;

/**
 * Created by pmz on 2017/5/26 16:21.
 */
public class AdapterTest {

    @Test
    public void testClass(){
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }
    @Test
    public void testObject(){
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }

    @Test
    public void testInterface(){
        Sourceable sourceable1 = new SourceSub1();
        Sourceable sourceable2 = new SourceSub2();
        sourceable1.method1();
        sourceable1.method2();
        sourceable2.method1();
        sourceable2.method2();
    }
}
