package generic;

/**
 * Created by pmz on 2017/5/18 10:10.
 */
public class Parent<T> {
    private T name;
    public void setName(T name){
        this.name = name;
        System.out.println("parent: "+this.name);
    }

    public T getName(){
        return this.name;
    }
    /**
     * 泛型实例化
     * @author pmz
     * @date 2017/5/18
     *
     */
    public T init(Class<T> c){
        T t = null;
        try {
            t = c.newInstance();
        }catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return t;
    }
    /** 
     * 不能在泛型类的静态域中使用泛型类型,但是泛型方法，可以
     * @author pmz 
     * @date 2017/5/18 
     *
     */
    /*public static T getInstance(){
        return null;
    };
    private static T sign;
    */
    public static <T> T getInstance(T t){
        return t;
    }
}
