package designpattern.singleton;

/**
 * Created by pmz on 2017/5/25 11:29.
 */
public class SingletonJVM {
    private SingletonJVM(){}



    private static class SingletonFactory{
        private static SingletonJVM instance = new SingletonJVM();
    }

    public static SingletonJVM getInstance(){
        return SingletonFactory.instance;
    }

    public Object readResolve(){
        return getInstance();
    }

    public static void main(String[] args) {
        SingletonJVM a = SingletonFactory.instance;
        System.out.println(a);
    }
}
