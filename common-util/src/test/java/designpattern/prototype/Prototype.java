package designpattern.prototype;

import java.io.*;

/**
 * Created by pmz on 2017/5/26 13:00.
 */
public class Prototype implements Cloneable,Serializable{
    private String name;
    private int age;

    private Body body = new Body();


//浅拷贝
    public Prototype clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }
    /* 深复制 */
    public Object deepClone() throws IOException,ClassNotFoundException{
/* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
/* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(String bodyName) {
        this.body.setBodyName(bodyName);
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", body=" + body +
                '}';
    }
}

