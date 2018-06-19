package reflect;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pmz on 2018/2/5 17:40.
 */
public class BeanUtilsTest {

    @Test
    public void t() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Student student = new Student();
        BeanUtils.setProperty(student,"age",2);
        System.out.println(student.getAge());
        System.out.println(BeanUtils.getProperty(student,"age").getClass().getName());
    }
    @Test
    public void copy() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Student student = new Student();
        List list = new ArrayList<>();
        student.setMarks(list);
        BeanUtils.setProperty(student,"age",2);
        System.out.println(student.getAge());
        System.out.println(BeanUtils.getProperty(student,"age").getClass().getName());
        Student student1 = (Student) BeanUtils.cloneBean(student);
        System.out.println(student == student1);
        System.out.println(student.getAge() == student1.getAge());
        System.out.println(student.getMarks() == student1.getMarks());
    }
}
