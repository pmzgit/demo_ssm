package designpattern.observer;

/**
 * Created by pmz on 2017/2/27 17:44.
 */
public class User2 implements Observer{
    @Override
    public void update() {
        System.out.println("user2 has received the update!");
    }
}
