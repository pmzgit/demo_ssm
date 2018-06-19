package lang;

/**
 * Created by pmz on 2018/2/2 17:25.
 */
public class Extender extends InnerClass.B{
    // 与外部类平级的类继承内部类时，其构造方法中需要传入父类的实例对象。且在构造方法的第一句调用“外部类实例名.super(内部类参数)”
    public Extender(InnerClass outer,String a) {
        outer.super(a);
    }
}
