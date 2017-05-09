package designpattern.observer;

/**
 * Created by pmz on 2017/2/27 17:45.
 * 一对多关系（类与类之间关系）
 */
public interface Subject {
    void add(Observer observer);
    void del(Observer observer);
    void notifyObservers();
    void operation();
}
