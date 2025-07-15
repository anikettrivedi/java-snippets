package inbuiltdatastructures;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;

public class JavaSynchronizedDataStructures {

    static Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    static Queue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
    static Queue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(10);

    static List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    static Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

    static Map<String, String> skipListMap = new ConcurrentSkipListMap<>();
    static Set<String> skipListSet = new CopyOnWriteArraySet<>();

}
