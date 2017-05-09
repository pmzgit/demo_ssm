package designpattern.observer;

/**
 * Created by pmz on 2017/2/27 18:01.
 */
public class MySubject extends AbstractSubject{
    @Override
    public void operation() {
        System.out.println("update myself");
        notifyObservers();
    }
}
