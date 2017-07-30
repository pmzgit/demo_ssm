package designpattern.factory;

/**
 * Created by pmz on 2017/6/9 19:35.
 * 中国式早餐
 */
public class ZCChinaStyle implements ZCFactory{
    @Override
    public Staple makeStaple() {
        return new YT();
    }

    @Override
    public Drink makeDrink() {
        return new DJ();
    }
}
