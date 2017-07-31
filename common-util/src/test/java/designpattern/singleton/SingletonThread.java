package designpattern.singleton;

import org.hamcrest.core.Is;

import java.util.Vector;

/**
 * Created by pmz on 2017/5/25 11:51.
 */
public class SingletonThread {
    private static SingletonThread instance = null;

    private Vector props = null;

    public Vector getProps(){
        return props;
    }

    private SingletonThread(){};

    private static synchronized void syncInit(){
        if (instance == null){
            instance = new SingletonThread();
        }
    }

    public static SingletonThread getInstance(){
        if (instance == null){
            syncInit();
        }
        return instance;
    }

    public void updateProps(){
        /*SingletonThread singletonThread = getInstance();
        singletonThread.props = getProps();*/
    }
}
