package jdk8;

/**
 * Created by pmz on 2018/5/1 12:42.
 */
public interface D extends B{
    /**
     * 重载 overloading
     1) 方法重载是让类以统一的方式处理不同类型数据的一种手段。多个同名函数同时存在，具有不同的参数个数/类型。重载是一个类中多态性的一种表现。
     2) Java的方法重载，就是在类中可以创建多个方法，它们具有相同的名字，但具有不同的参数和不同的定义。调用方法时通过传递给它们的不同参数个数和参数类型给它们的不同参数个数和参数类型给它们的不同参数个数和参数类型来决定具体使用哪个方法, 这就是多态性。
     3) 重载的时候，方法名要一样，但是参数类型和个数不一样，返回值类型可以相同也可以不相同。无法以返回型别作为重载函数的区分标准。
     * 重写overriding
     1) 父类与子类之间的多态性，对父类的函数进行重新定义。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。在Java中，子类可继承父类中的方法，而不需要重新编写相同的方法。但有时子类并不想原封不动地继承父类的方法，而是想作一定的修改，这就需要采用方法的重写。方法重写又称方法覆盖。

     2) 若子类中的方法与父类中的某一方法具有相同的方法名、返回类型和参数表，则新方法将覆盖原有的方法。如需父类中原有的方法，可使用super关键字，该关键字引用了当前类的父类。

     3) 子类函数的访问修饰权限不能少于父类的；
     * @author pmz
     * @date 2018/5/1
     *
     */
    @Override
    default String getName(){
        return "d";
    }
}
