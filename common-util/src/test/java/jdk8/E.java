package jdk8;

/**
 * Created by pmz on 2018/5/1 13:37.
 */
public interface E extends D{

    String getName();
    /**
     * http://ebnbin.com/2015/12/20/java-8-default-methods/
     * 不覆写父接口的默认方法，直接用父接口的方法实现。（参考 B 接口）
     * 覆写父接口的默认方法，用自己的实现。（参考 D 接口）
     * 覆写父接口的默认方法实现，并将其更改为抽象方法。（参考 E 接口）,当把默认方法改为抽象方法后，那么实现类就必须去实现该抽象方法了。
     * @author pmz
     * @date 2018/5/1
     *
     */
    public static void main(String[] args) {
        System.out.println(new DefaultMethod() {}.getName());
        DefaultMethod.printHelloWorld();
        System.out.println(new B() {}.getName());
        System.out.println(new D() {}.getName());
        System.out.println(new E(){
            @Override
            public String getName() {
                return "e";
            }
        }.getName());
    }
}
