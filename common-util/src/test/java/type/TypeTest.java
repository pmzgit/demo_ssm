package type;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by pmz on 2018/2/4 16:13.
 */
public class TypeTest<T> {
    private List<T> list = null;
    private Set<T> set = null;
    private Map<String,Integer> map = null;
    private List<String>[] lists = null;
    private T[] ts = null;

    public static void main(String[] args) {
        try {
            Field list = TypeTest.class.getDeclaredField("list");
            Type typeList = list.getGenericType();
            System.out.println(typeList.getClass().getName());
            Field set = TypeTest.class.getDeclaredField("set");
            Type typeSet = set.getGenericType();
            System.out.println(typeSet.getClass().getName());
            System.out.println(typeSet.getTypeName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void actualTypeArgs(){
        try {
            Field fieldMap = getClass().getDeclaredField("map");
            Type TypeMap = fieldMap.getGenericType();
            ParameterizedType parameterizedType = (ParameterizedType) TypeMap;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            System.out.println(actualTypeArguments[0]);
            System.out.println(actualTypeArguments[1]);
            Type rawType = parameterizedType.getRawType();
            System.out.println(rawType.getTypeName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void typeArray(){
        try {
            Field fieldArry = getClass().getDeclaredField("lists");
            Type typeListArray = fieldArry.getGenericType();
            System.out.println(typeListArray.getClass().getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void componet(){
        Field fieldArry = null;
        try {
            fieldArry = getClass().getDeclaredField("lists");
            Field ts = getClass().getDeclaredField("ts");
            Type TypeTs = ts.getGenericType();
            GenericArrayType typeTs = (GenericArrayType) TypeTs;
            Type genericComponentType = typeTs.getGenericComponentType();
            System.out.println(genericComponentType.getClass().getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Type typeListArray = fieldArry.getGenericType();
        GenericArrayType typeListArray1 = (GenericArrayType) typeListArray;
        Type type = typeListArray1.getGenericComponentType();
        System.out.println(type.getClass().getName());
    }
}
