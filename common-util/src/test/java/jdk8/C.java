package jdk8;

/**
 * Created by pmz on 2018/5/1 12:33.
 */
public class C implements DefaultMethod{
    /**
     * 在具体的接口实现类中也可以对接口中的默认方法进行覆写
     * @author pmz
     * @date 2018/5/1
     *
     */
    @Override
    public String getName(){
        return "c";
    }

    public static void main(String[] args) {
        System.out.println(new C().getName());
        System.out.println(new C().getName());
    }
}
