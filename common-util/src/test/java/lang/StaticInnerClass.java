package lang;

/**
 * Created by pmz on 2018/2/2 17:34.
 */
public class StaticInnerClass {
    private String outProp = "outProp";
    private static String staticProp = "outer-staticProp"; // 编译后会分成两个class文件所以，内外部类的属性名可以相同；
    public static class C {
        private static String staticProp = "inner-staticProp";
        private String prop;

        public static void staticMethod (int i){
            System.out.println(i);
            System.out.println("不可访问外部类非static属性/方法"+staticProp);
        }
        public void staticMethod1 (int i){
            System.out.println(i);
            System.out.println("访问内部类普通属性/方法"+this.prop);
//            System.out.println("访问内部类普通属性/方法"+StaticInnerClass.this.outProp);
        }
    }
}
