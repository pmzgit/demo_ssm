package lang;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by pmz on 2017/7/26 20:37.
 */
@Ignore
public class LangTest {
    /**
     * 基本数据类型 转换 自动 和 强制 转换
     * @author pmz
     * @date 2017/7/26
     *
     */
    // 字面量赋值 变量赋值 区别
    @Test
    public void t1(){
        byte a = 1;
        int b = 3;
        byte c = (byte) b;
        char e = 3;
        System.out.println(c);

        int f = 233;
        byte g = (byte) f;
        System.out.println(g);
    }
    // 数学运算 当进行数学运算时，数据类型会自动发生提升到运算符左右之较大者 只要不超出数值范围，整形的精度就不会丢失
    @Test
    public void t2(){
        int a = 9;
        byte b = 1;
        byte c = (byte) (a + b);
        System.out.println(c);
    }

}
