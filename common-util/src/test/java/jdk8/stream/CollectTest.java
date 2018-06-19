package jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by pmz on 2018/5/30 18:04.
 */
public class CollectTest {
    @Test
    public void t1(){
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
// 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 1. Array
        String[] strArray1 = (String[]) stream.toArray(String[]::new);
// 2. Collection
        List<String> list1 = (List<String>) stream.collect(Collectors.toList());
        List<String> list2 = (List<String>) stream.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = (Set) stream.collect(Collectors.toSet());
        Stack stack1 = (Stack) stream.collect(Collectors.toCollection(Stack::new));
// 3. String
        String str = stream.collect(Collectors.joining()).toString();
    }
}
