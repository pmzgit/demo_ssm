package jdk8;

/**
 * Created by pmz on 2018/5/1 12:31.
 * https://blog.csdn.net/airsaid/article/details/51017534
 * 就算在接口中增加了新的默认方法，具体的实现类也无需改动就有了新功能。

 默认方法的出现就是为了保证原有代码兼容性的同时在接口中增加新的功能。
 *
 * 注意：
 * default 关键字只能在接口中使用（以及用在 switch 语句的 default 分支），不能用在抽象类中。

 * 接口默认方法不能覆写 Object 类的 equals、hashCode 和 toString 方法。

 * 接口中的静态方法必须是 public 的，public 修饰符可以省略，static 修饰符不能省略。

 * 即使使用了 java 8 的环境，一些 IDE 仍然可能在一些代码的实时编译提示时出现异常的提示（例如无法发现 java 8 的语法错误），因此不要过度依赖 IDE。
 */
public interface DefaultMethod {
    //默认方法不可以被 private 修饰，默认就是 public 的，public 可以省略不写。
    public default String getName(){
        return "a";
    }
    /**
     * 只不过在接口中，默认是由 public 所修饰的，并且同默认方法一样，是不可以更改为 private 的。

     调用时，直接接口名.方法名：
     * @author pmz
     * @date 2018/5/1
     *
     */
    static void printHelloWorld() {
        System.out.println("hello, world");
    }
}
