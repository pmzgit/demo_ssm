package reflect;

import java.util.List;

/**
 * Created by pmz on 2017/5/18 18:02.
 */
public class Student implements Comparable<Student>{
    private static final long serialVersionUID = -1059865761515029835L;

    // 年龄
    private int age;

    // 备注
    private List<String> marks;

    public Student() {
    }

    private Student(int age) {
        this.age = age;
    }

    public Student(List<String> marks) {
        this.marks = marks;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getMarks() {
        return marks;
    }

    public void setMarks(List<String> marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        if (this.getAge() == o.getAge()) {
            return 0;
        }
        if (this.getAge() > o.getAge()) {
            return -1;
        } else {
            return 1;
        }
    }
}
