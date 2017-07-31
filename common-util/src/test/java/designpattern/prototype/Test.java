package designpattern.prototype;

import java.io.IOException;

/**
 * Created by pmz on 2017/5/26 13:19.
 */
public class Test {

    @org.junit.Test
    public void test1() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype = new Prototype();
        prototype.setName("name1");
        prototype.setAge(1);
        prototype.setBody("bodyName1");
        prototype.getBody().setHead("head");

       /* Prototype prototypeCopy = prototype.clone();
        prototypeCopy.setName("namecopy");
        prototypeCopy.setAge(2);
        prototypeCopy.setBody("bodycopy");
        prototypeCopy.getBody().setHead("headcopy");
        System.out.println(prototypeCopy.toString());*/
        System.out.println(prototype.toString());


        Prototype prototypeDeep = (Prototype) prototype.deepClone();

        prototypeDeep.setName("deepcopy");
        prototypeDeep.setBody("deepCopy");
        prototypeDeep.getBody().setHead("deepcopy");

        System.out.println(prototypeDeep);
    }
}
