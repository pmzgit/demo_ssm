package math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/2/8.
 */
public class MathTest {
    @Test
    public void testRound(){
        System.out.println(0.05+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);
        //
        double d = 2.4;
        System.out.println(d);
    }
    /**
     * DecimalFormat 类主要靠 # 和 0 两种占位符号来指定数字长度。0 表示如果位数不足则以 0 填充，# 表示只要有可能就把数字拉上这个位置
     * @author pmz
     * @date 2017/2/9
     */
    @Test
    public void testFormat(){
        double pi=3.1415927;//圆周率
        System.out.println(Double.toString(pi));
        //取一位整数
        System.out.println(new DecimalFormat("0").format(pi)); //3
        //取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14
        //取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(pi));// 03.142
        //取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));//3
        //以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%

        long c=299792458;//光速
        //显示为科学计数法，并取五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(c));//2.99792E8
        //显示为两位整数的科学计数法，并取四位小数
        System.out.println(new DecimalFormat("00.####E0").format(c));//29.9792E7
        //每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(c));//299,792,458
        //将格式嵌入文本
        System.out.println(new DecimalFormat("光速大小为每秒,###米。").format(c));


        DecimalFormat df = new DecimalFormat();
        double data = 1234.56489;
        System.out.println("格式化之前的数字: " + data);
        String style = "0.0";//定义要显示的数字的格式
        df.applyPattern(style);// 将格式应用于格式化器
        System.out.println("采用style: " + style + ", 格式化之后: " + df.format(data));
        style = "00000.000 kg";//在格式后添加诸如单位等字符
        df.applyPattern(style);
        System.out.println("采用style: " + style + ", 格式化之后: " + df.format(data));
        // 模式中的"#"表示如果该位存在字符，则显示字符，如果不存在，则不显示。
        style = "##000.000 kg";
        df.applyPattern(style);
        System.out.println("采用style: " + style + ", 格式化之后: " + df.format(data));
        // 模式中的"-"表示输出为负数，要放在最前面
        style = "-000.000";
        df.applyPattern(style);
        System.out.println("采用style: " + style + ", 格式化之后: " + df.format(data));
        // 模式中的","在数字中添加逗号，方便读数字
        style = "-0,000.00";
        df.applyPattern(style);
        System.out.println("采用style: " + style + ", 格式化之后: " + df.format(data));
        // 模式中的"E"表示输出为指数，"E"之前的字符串是底数的格式，
        // "E"之后的是字符串是指数的格式
        style = "0.00E000";
        df.applyPattern(style);
        System.out.println("采用style: " + style + ", 格式化之后: " + df.format(data));
        // 模式中的"%"表示乘以100并显示为百分数，要放在最后。
        style = "0.00%";
        df.applyPattern(style);
        System.out.println("采用style: " + style + ", 格式化之后: " + df.format(data));
        // 模式中的"\u2030"表示乘以1000并显示为千分数，要放在最后。
        style = "0.00\u2030";
        //在构造函数中设置数字格式
        DecimalFormat df1 = new DecimalFormat(style);
        //df.applyPattern(style);
        System.out.println("采用style: " + style + " , 格式化之后: " + df1.format(data));
    }
    @Test
    public void rountTest(){
        System.out.println(new BigDecimal(2.63));
        System.out.println(new BigDecimal("2.63"));
        System.out.println(new BigDecimal(2.4).setScale(0, RoundingMode.HALF_UP).intValue());

    }
}
