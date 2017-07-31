package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by pmz on 2017/5/19 12:39.
 */
public class InfoAnnotationParser {
    public static void main(String[] args) {

        try {
            Class<?> infoClass = InfoAnnotationParser.class.getClassLoader().loadClass(Info.class.getName());
            Field[] fields = infoClass.getDeclaredFields();
            for (Field field: fields){
                if (field.isAnnotationPresent(InfoFieldAnnotation.class)){
                    InfoFieldAnnotation annotation = field.getAnnotation(InfoFieldAnnotation.class);
                    System.out.println("field = " + field.getName() + " , value = " + annotation.value());
                }
            }
            Method[] methods = infoClass.getMethods();
            for (Method method: methods){
                if (method.isAnnotationPresent(InfoMethodAnnotation.class)){
                    InfoMethodAnnotation annotation = method.getAnnotation(InfoMethodAnnotation.class);
                    System.out.println("method = " + method.getName() + " , author = " + annotation.author() + " , version = " + annotation.version());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
