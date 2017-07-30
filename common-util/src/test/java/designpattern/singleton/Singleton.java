package designpattern.singleton;

/**
 * Created by pmz on 2017/5/25 11:24.
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton(){
    }

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    public Object readResolve(){
        return instance;
    }

    public static void main(String[] args) {
//        Singleton a = Singleton.instance;
        Singleton a = Singleton.getInstance();
        System.out.println(a);
    }
}
