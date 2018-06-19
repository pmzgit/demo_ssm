package collections;

import java.util.*;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void testToString() {
        final int ARRAY_SIZE = 10;
        String[] array1 = new String[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++)
            array1[i] = i+"";

        // toString用法
        System.out.println("Arrays.toString用法：" + Arrays.toString(array1));
        System.out.println(Arrays.toString(new char[]{'a','b'}));
        final int DEEP_ARRAY_SIZE = 3;
        int[][] array2 = new int[DEEP_ARRAY_SIZE][DEEP_ARRAY_SIZE];
        for (int i = 0; i < DEEP_ARRAY_SIZE; i++)
            for (int j = 0; j < DEEP_ARRAY_SIZE; j++)
                array2[i][j] = i + j;

        // deepToString用法
        System.out.println("Arrays.deepToString用法：" + Arrays.deepToString(array2));
    }

    @Test
    public void testOther() {
        final int ARRAY_SIZE = 5;
        int[] array = new int[ARRAY_SIZE];

        // fill填充
        Arrays.fill(array, 5);
        System.out.println("fill后值：" + Arrays.toString(array));

        // sort排序，先填充随机值，然后排序
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++)
            array[i] = random.nextInt(ARRAY_SIZE * 10);
        System.out.println("原始顺序：" + Arrays.toString(array));
        Arrays.sort(array,0,3);
        System.out.println("sort后顺序：" + Arrays.toString(array));

        String[] strarr = {"hello","world","Break","abc"};
        Arrays.sort(strarr,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(strarr));
        Arrays.sort(strarr,Collections.<String>reverseOrder(String.CASE_INSENSITIVE_ORDER));
        // binarySearch搜索，先设置一个值，然后找
        array[3] = 37;
        int pos = Arrays.binarySearch(array, 37);
        System.out.println("查找到的位置：" + pos);

        int[] intarr = {0,3,2,8,9,4,2};
        int[] subintarr = Arrays.copyOfRange(intarr,2,5);
        int[] subintarr1 = Arrays.copyOfRange(intarr,2,10);
        System.out.println(Arrays.toString(subintarr));
        System.out.println(Arrays.toString(subintarr1));



    }

    @Test
    public void testCollections(){
        List<Integer> intList = Arrays.asList(22,3,19,20,22);
        System.out.println(Collections.min(intList));
        System.out.println(Collections.max(intList));
        String aa = "sss";
        System.out.println(aa.compareTo("st"));

    }

    @Test
    public void testJdkImmutable(){
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list);

        List<String> unmodifiableList=Collections.unmodifiableList(list);

        System.out.println(unmodifiableList);

        List<String> unmodifiableList1=Collections.unmodifiableList(Arrays.asList("a","b","c"));
        System.out.println(unmodifiableList1);

        String temp=unmodifiableList.get(1);
        System.out.println("unmodifiableList [0]："+temp);

        list.add("baby");
        System.out.println("list add a item after list:"+list);
        System.out.println("list add a item after unmodifiableList:"+unmodifiableList);

//        unmodifiableList1.add("bb");
        System.out.println("unmodifiableList add a item after list:"+unmodifiableList1);

//        unmodifiableList.add("cc");
        System.out.println("unmodifiableList add a item after list:"+unmodifiableList);
        List<Integer> intList = Collections.<Integer>emptyList();
        String[] a = list.toArray(new String[0]);
        System.out.println(a.length);
    }

    @Test
    public void subList(){
//        http://cmsblogs.com/?p=1239
//        http://cmsblogs.com/?p=1220
        List<Object> lists = new ArrayList<Object>();

        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");

        List<Object> tempList = lists.subList(2, lists.size());

        tempList.add("6");
        System.out.println(tempList.get(1));
        System.out.println(tempList); // 1

        System.out.println(lists); // 2
        System.out.println(lists.equals(tempList));
    }
    @Test
    public void toArray(){
        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        String[] array = new String[list.size()];
//        array = list.toArray(array);
        list.toArray(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void asList(){
        int ARRAY_SIZE = 5;
        // Arrays.asList方法调用
        String[] strarray = new String[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++)
            strarray[i] = "str" + i;
        System.out.println("Arrays.asList将Array转换为List后，对List遍历：");
        List<String> list = Arrays.asList(strarray);
        for (String str : list)
            System.out.println(str);
        strarray[0] = "aa";
        System.out.println(list.toString());
        list.set(2, "bb");

        System.out.println(list.toString());
        System.out.println(Arrays.toString(strarray));
    }
}