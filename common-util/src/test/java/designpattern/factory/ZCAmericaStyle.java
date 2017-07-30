package designpattern.factory;

/**
 * Created by pmz on 2017/6/9 19:45.
 */
public class ZCAmericaStyle implements ZCFactory{
    @Override
    public Staple makeStaple() {
        return new MB();
    }

    @Override
    public Drink makeDrink() {
        return new NN();
    }
}
