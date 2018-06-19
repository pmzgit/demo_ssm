package lang;

/**
 * Created by pmz on 2018/1/31 20:56.
 */
public class InnerClass {

    private String memberProp = "这是外部类成员变量";
    private static Integer  staticProp = 1;

    //成员内部类
    //不对外开放，高内聚
    class B {
        private String innerProp = "这是内部类成员变量";
//        private static Integer  staticProp = 1; 不予许
        private B(){
            //当内部类的构造器为Protected、private修饰时外部类外不可以访问
        }
        public B(String a){
            this.innerProp = a;
        }
        public void innerMethod(){
            System.out.println("这是内部类B的innerMethod方法,访问外部类成员变量："+ InnerClass.this.memberProp);//内部类访问外部类成员变量
            System.out.println("这是内部类B的innerMethod方法,访问外部类变量"+ InnerClass.staticProp);//内部类访问外部类变量
        }
    }
    //可供成员的外部类中其他方法调用
    public B show(){
        return  this.new B(); //外部类调用
    }
    // 此段代码无意义
    public static void main(String[] args) {
        new InnerClass().new B().innerMethod(); //外部类外访问内部类
        new InnerClass().new B("2").innerMethod(); //外部类外访问内部类
    }
}
