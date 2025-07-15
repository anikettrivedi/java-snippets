package inbuiltdatastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;

public class JavaDataStructures {

    static String string = "";

    static List<String> arrayList = new ArrayList<>();
    static List<String> linkedList = new LinkedList<>();

    static Map<String, String> map = new HashMap<>();
    static Map<String, String> treeMap = new TreeMap<>();
    static Map<String, String> linkedHashMap = new LinkedHashMap<>();

    static Set<String> set = new HashSet<>();
    static Set<String> treeSet = new TreeSet<>();
    static Set<String> linkedHashSet = new LinkedHashSet<>();

    static Stack<String> stack = new Stack<>();

    static Queue<String> queue = new LinkedList<>();
    static Queue<String> queue2 = new ArrayDeque<>();

    static PriorityQueue<String> pq = new PriorityQueue<>();

    static Hashtable<String, String> hashtable = new Hashtable<>();

    public static void main(String[] args) {
        System.out.println(set.add("hello"));
        System.out.println(set.add("hello"));
    }

}
