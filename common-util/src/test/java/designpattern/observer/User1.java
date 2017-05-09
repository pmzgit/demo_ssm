package designpattern.observer;

/**
 * Created by pmz on 2017/2/27 17:41.
 */
public class User1 implements Observer{
    @Override
    public void update() {
        System.out.println("user1 has received the update!");
    }
}
