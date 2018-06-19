package lang;

import org.junit.Test;

/**
 * Created by pmz on 2018/1/31 21:06.
 * 参考 https://www.cnblogs.com/lgk1002/p/6069784.html
 * 参考 https://www.cnblogs.com/dorothychai/p/6007709.html
 * 参考 https://www.jianshu.com/p/e385ce41ca5b
 */
public class OtherClass {
    public static void main(String[] args) {
        InnerClass.B b = new InnerClass().new B("2");
        b.innerMethod(); //外部类外访问内部类-公共构造器
//        new InnerClass().new B().innerMethod(); //外部类外访问内部类-私有构造器，报编译错误

        new MethodInnerClass().method(); //局部内部类只能在代码代码块、方法体内和作用域中使用（如创建对象和使用类对象等）
    }
    //匿名内部类语法格式
     //1、new 抽象类或者接口
      //2、后加大括号
      //3、实现未实现方法
    // 是局部内部类，所以要符合局部内部类的要求。
    // 单独的class文件，使用类$数字.class

    public Qinshou getAnoymous(int x){
        final int y = 100;
//        int y = 100;
        return new Qinshou() {
            int z = 200;
            @Override
            public void workInNight() {
//                System.out.println(x+y+z);
//                System.out.println(y+=1);
            }
        };
    }

    @Test
    public void testAnoymoous(){
        /**
         *
         * 1、匿名内部类不能定义任何静态成员、方法。（为什么？）

         2、匿名内部类中的方法不能是抽象的；（为什么？）

         3、匿名内部类必须实现接口或抽象父类的所有抽象方法。

         4、匿名内部类不能定义构造器；

         5、匿名内部类访问的外部类成员变量或成员方法必须用static修饰；

         6、内部类可以访问外部类私有变量和方法。
         *
         */
       /* Doctor doctor = new Doctor() {
            @Override
            public void workInNight() {
                System.out.println("匿名内部类用法");
            }
        };
        doctor.workInDay();
        doctor.workInNight();*/

       Qinshou qinshou = new OtherClass().getAnoymous(2);
       qinshou.workInNight();
    }
    @Test
    public void testStaticInnerClass(){
        StaticInnerClass.C c = new StaticInnerClass.C();
        StaticInnerClass.C.staticMethod(1);
        c.staticMethod1(2);
    }
}
