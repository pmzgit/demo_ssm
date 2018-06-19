package jdk8.stream;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by pmz on 2018/5/30 18:02.
 */
public class NumTest {
    @Test
    public void t1(){
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
}
}
