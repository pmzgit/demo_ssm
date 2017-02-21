package lang;

import sun.applet.Main;
import sun.nio.cs.FastCharsetProvider;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by pmz on 2017/2/19 19:10.
 * 所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。
 * java.util.EnumSet和java.util.EnumMap是两个枚举集合。EnumSet保证集合中的元素不重复；EnumMap中的key是enum类型，而value则可以是任意类型。
 */
public enum ColorEnum implements Serializable{
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4){
        public boolean isColor(){
            return true;
        }
    };
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    ColorEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (ColorEnum c : ColorEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public boolean isColor(){
        return false;
    }
    public String toString(){
        return this.index + "_" + this.name;
    }


    public static void main(String[] args) {
        System.out.println(ColorEnum.YELLO.isColor());
        System.out.println(ColorEnum.GREEN.toString());
        System.out.println(ColorEnum.BLANK.ordinal());
        System.out.println(ColorEnum.RED.name());

        // EnumSet的使用
        EnumSet<ColorEnum> weekSet = EnumSet.allOf(ColorEnum.class);
        for (ColorEnum day : weekSet) {
            System.out.println(day);
        }

        // EnumMap的使用
        EnumMap<ColorEnum, String> weekMap = new EnumMap(ColorEnum.class);
        weekMap.put(ColorEnum.RED, "星期一");
        weekMap.put(ColorEnum.GREEN, "星期二");
        // ... ...
        for (Iterator<Map.Entry<ColorEnum, String>> iter = weekMap.entrySet().iterator(); iter.hasNext();) {
            Map.Entry<ColorEnum, String> entry = iter.next();
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
    }
}
