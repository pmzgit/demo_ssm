package lang;

import org.junit.Test;

/**
 * Created by pmz on 2017/2/22 16:55.
 */
public class FinalTest {
    /*
    * 如果final修饰的是一个基本类型，就表示这个变量被赋予的值是不可变的，即它是个常量；
    * 如果final修饰的是一个对象，就表示这个变量被赋予的引用是不可变的，这里需要提醒大家注意的是，
     不可改变的只是这个变量所保存的引用，并不是这个引用所指向的对象。
    *如果一个变量或方法参数被final修饰，就表示它只能被赋值一次，但是JAVA虚拟机为变量设定的默认值不记作一次赋值。
    *被final修饰的变量必须被初始化。初始化的方式有以下几种：
        1. 在定义的时候初始化。
        2. final变量可以在初始化块中初始化，不可以在静态初始化块中初始化。
        3. 静态final变量可以在静态初始化块中初始化，不可以在初始化块中初始化。
        4. final变量还可以在类的构造器中初始化，但是静态final变量不可以。
        通过下面的代码可以验证以上的观点：
    * 用final修饰的变量（常量）比非final的变量（普通变量）拥有更高的效率，
    * */
    // 在定义时初始化
    public final int A = 10;
    public final int B;
    // 在初始化块中初始化
    {
        B = 20;
    }
    // 非静态final变量不能在静态初始化块中初始化
// public final int C;
// static {
// C = 30;
// }
// 静态常量，在定义时初始化
    public static final int STATIC_D = 40;
    public static final int STATIC_E;
    // 静态常量，在静态初始化块中初始化
    static {
        STATIC_E = 50;
    }
    // 静态变量不能在初始化块中初始化
// public static final int STATIC_F;
// {
// STATIC_F = 60;
// }
    public final int G;
    // 静态final变量不可以在构造器中初始化
// public static final int STATIC_H;
// 在构造器中初始化
    public FinalTest() {
        G = 70;
// 静态final变量不可以在构造器中初始化
// STATIC_H = 80;
// 给final的变量第二次赋值时，编译会报错
// A = 99;
// STATIC_D = 99;
    }
// final变量未被初始化，编译时就会报错
// public final int I;
// 静态final变量未被初始化，编译时就会报错
// public static final int STATIC_J;


    /*
    * 当final用来定义一个方法时,表示这个方法不可以被子类重写，但是它这不影响它被子类继承。
    * 由于final类不允许被继承，编译器在处理时把它的所有方法都当作final的，因此final类比普通类拥有更高的效率。
    * final的类的所有方法都不能被重写，但这并不表示final的类的属性（变量）值也是不可改变的，要想做到final类的属性值不可改变，必须给它增加final修饰，请看下面的例子：
    * */
    String generalField = "some str";
    @Test
    public void testField(){
        FinalTest finalClass = new FinalTest();
        finalClass.generalField = "another str";
//        finalClass.G = 2;
    }

}
