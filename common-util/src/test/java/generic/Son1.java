package generic;

import java.util.Comparator;

/**
 * Created by pmz on 2017/5/18 10:54.
 * 继承泛型类时，必须对父类中的类型参数进行初始化。或者说父类中的泛型参数必须在子类中可以确定具体类型。或者在继承时，父类不使用泛型
 */
public class Son1 extends Parent1<Parent1> implements Comparator<Parent1>{
}
