package generic;

/**
 * Created by pmz on 2017/5/18 10:12.
 */
public class Son extends Parent<String>{
    public void setName(String name){
        System.out.println("son: "+name);
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.setName("aaa");
//        son.setName(new Object());
        Parent parent = son;
        parent.setName(new Object());//will show runtime exception： ClassCastException

        /*Son son = new Son();
        System.out.println(son.init(String.class));*/
        Integer instance = Son.getInstance(1);
        System.out.println(instance.intValue());


    }
}
