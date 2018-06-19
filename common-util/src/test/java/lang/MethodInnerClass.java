package lang;

/**
 * Created by pmz on 2018/2/2 11:49.
 */
public class MethodInnerClass {

    class InnerClass1{
        public void method(){
            System.out.println("成员内部类中的公开方法");
        }
    }
    private String member="全局变量";
    int n = 4;
    public void method(){
        final String member = "局部变量";
        final int n = 3; //方法内的变量只有final变量才能被方法内部类访问(此话不懂)
        //每个内部类都能独立地继承自一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，
                 //对于内部类都没有影响
                 //内部类使得多重继承的解决方案变得完整。接口解决了部分问题，而内部类有效地实现了“多重继承”
                //短暂，不对外，防止变成全局
        class B extends InnerClass{
            public void show1(){
                System.out.println(member+n);
            }
        }
        System.out.println("方法内实例化局部内部类并调用局部内部类方法");
        //局部内部类只能在代码代码块、方法体内和作用域中使用（如创建对象和使用类对象等）
        new B().show1();
        new B().show(); // 继承的方法
    }
}
