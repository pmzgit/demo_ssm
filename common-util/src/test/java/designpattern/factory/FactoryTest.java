package designpattern.factory;

import org.junit.Test;

/**
 * Created by pmz on 2017/6/9 19:46.
 */
public class FactoryTest{

    @Test
    public void testAbatract(){
        Staple zs;
        Drink yl;
        System.out.println("中餐组合。。。");
        ZCFactory china = new ZCChinaStyle();
        zs = china.makeStaple();
        yl = china.makeDrink();
        zs.eating();
        yl.drinking();
        System.out.println("西餐组合....");
        ZCFactory america = new ZCAmericaStyle();
        zs = america.makeStaple();
        yl = america.makeDrink();
        zs.eating();
        yl.drinking();
    }
}
