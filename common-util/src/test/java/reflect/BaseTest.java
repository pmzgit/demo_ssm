package reflect;

import generic.Parent;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.List;

/**
 * Created by pmz on 2017/5/18 16:56.
 */
public class BaseTest {
    @Test
    public void init() {
        Class<Parent> parentClass = Parent.class;
        Parent<String> parent = null;
        try {
            parent = parentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(parentClass.getName());
        System.out.println(parentClass.getSimpleName());
        System.out.println(parentClass.getSuperclass());
        System.out.println(parentClass.getInterfaces());
        parentClass.getConstructors();
        try {
            Constructor<Parent> def = parentClass.getDeclaredConstructor();
            Parent parent1 = def.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        parentClass.getMethods();
        parentClass.getFields();

        try {
            Field name = parentClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(parent,"22");
            System.out.println(parent.getName());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Method setName = parentClass.getMethod("setName",Object.class);
            setName.invoke(parent,"aa");
            parent.getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void arrayReflection(){
        Object array = Array.newInstance(String.class,3);
        Array.set(array,0,"a");
        Array.set(array,1,"b");
        System.out.println(Array.get(array,1));
    }
    /**
     * 反射与泛型
     * @author pmz
     * @date 2018/2/5
     *
     */
    @Test
    public void genericFlection(){
        Class<Student> studentClass = Student.class;
        try{
            Field marks = studentClass.getDeclaredField("marks");
            Type genericType = marks.getGenericType();
            getGenericTypeName(genericType);

            Method getMarks = studentClass.getDeclaredMethod("getMarks");
            Type returnGenericType = getMarks.getGenericReturnType();
            getGenericTypeName(returnGenericType);

            Method setMarks = studentClass.getDeclaredMethod("setMarks", List.class);
            for (Type type: setMarks.getGenericParameterTypes()){
                getGenericTypeName(type);
            }

            Constructor<?>[] constructors = studentClass.getDeclaredConstructors();
            for (Constructor<?> constructor :constructors){
                for (Type genericParaType :constructor.getGenericParameterTypes()){
                    getGenericTypeName(genericParaType);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void getGenericTypeName(Type genericType){
        if (genericType instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTA : actualTypeArguments){
                if (actualTA instanceof Class){
                    Class clz = (Class) actualTA;
                    System.out.println(clz.getName());
                }
            }
        }else {
            System.out.println("null");
        }
    }
}
