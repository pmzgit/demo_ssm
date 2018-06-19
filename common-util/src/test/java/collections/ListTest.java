package collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pmz on 2017/9/23 21:09.
 */
public class ListTest {

    @Test
    public void t1(){
        //创建ArrayList集合：
        List<String> list = new ArrayList<String>();
        System.out.println("ArrayList集合初始化容量："+list.size());

        //添加功能：
        list.add("Hello");
        list.add("world");
        list.add(2,"!");
        list.add(2,"22");
        System.out.println("ArrayList当前容量："+list.size());

        //修改功能：
        list.set(0,"my");
        list.set(1,"name");
        System.out.println("ArrayList当前内容："+list.toString());

        //获取功能：
        String element = list.get(2);
        System.out.println(element);

        //迭代器遍历集合：(ArrayList实际的跌倒器是Itr对象)
        Iterator<String> iterator =  list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

        //for循环迭代集合：
        for(String str:list){
            System.out.println(str);
        }

        //判断功能：
        boolean isEmpty = list.isEmpty();
        boolean isContain = list.contains("my");

        //长度功能：
        int size = list.size();

        //把集合转换成数组：
        String[] strArray = list.toArray(new String[]{});

        //删除功能：
        list.remove(0);
        list.remove("world");
        list.clear();
        System.out.println("ArrayList当前容量："+list.size());
    }

    @Test
    public void t2(){
        List<String> linkedList = new LinkedList<String>();
        System.out.println("LinkedList初始容量："+linkedList.size());

        //添加功能：
        linkedList.add("my");
        linkedList.add("name");
        linkedList.add("is");
        linkedList.add("jiaboyan");
        System.out.println("LinkedList当前容量："+ linkedList.size());

        //修改功能:
        linkedList.set(0,"hello");
        linkedList.set(1,"world");
        System.out.println("LinkedList当前内容："+ linkedList.toString());

        //获取功能：
        String element = linkedList.get(0);
        System.out.println(element);

        //遍历集合：(LinkedList实际的跌倒器是ListItr对象)
        Iterator<String> iterator =  linkedList.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        //for循环迭代集合：
        for(String str:linkedList){
            System.out.println(str);
        }

        //判断功能：
        boolean isEmpty = linkedList.isEmpty();
        boolean isContains = linkedList.contains("jiaboyan");

        //长度功能：
        int size = linkedList.size();

        //删除功能：
        linkedList.remove(0);
        linkedList.remove("jiaboyan");
        linkedList.clear();
        System.out.println("LinkedList当前容量：" + linkedList.size());

    }

    //迭代次数
    public static int ITERATION_NUM = 100000;
    @Test
    public void t3(){
        insertPerformanceCompare();
    }


    //新增性能比较：
    public static void insertPerformanceCompare(){
//        Thread.sleep(5000);

        System.out.println("LinkedList新增测试开始");
        long start = System.nanoTime();
        List<Integer> linkedList = new LinkedList<Integer>();
        for (int x = 0; x < ITERATION_NUM; x++) {
            linkedList.add(x);
        }
        long end = System.nanoTime();
        System.out.println(end - start);

        System.out.println("ArrayList新增测试开始");
        start = System.nanoTime();
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int x = 0; x < ITERATION_NUM; x++) {
            arrayList.add(x);
        }
        end = System.nanoTime();
        System.out.println(end - start);
    }
    @Test
    public void t4(){
        List<String> list = new ArrayList<String>();
        list.add("2");
        list.add("1");
        System.out.println(list);
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);
    }

    @Test
    public void t5(){
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);

        //通过构造函数新建一个包含list1的列表 list2
        List<Integer> list2 = new ArrayList<Integer>(list1);

        //通过subList生成一个与list1一样的列表 list3
        List<Integer> list3 = list1.subList(0, list1.size());

        //修改list3
        list3.add(3);

        System.out.println("list1 == list2：" + list1.equals(list2));
        System.out.println("list1 == list3：" + list1.equals(list3));
    }

}
