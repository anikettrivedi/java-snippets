package coding.leetcode150;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(1);
        set.add(4);
        set.add(2);
        System.out.println(set.pollLast());
        System.out.println(set.pollFirst());
        System.out.println(set.pollFirst());

    }
}