package performance.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinkedListPerformance {

    private static List<Integer> linkedList;

    public static void main(String[] args) {
        System.out.println("LinkedList");
        System.out.println("*****************");
        insertWithoutInitialCapacity();
        System.out.println("*****************");
        insertAtRandomIndex();
        System.out.println("*****************");
        sequencialReads();
        System.out.println("*****************");
        deletionAtRandomIndex();
    }

    private static void insertWithoutInitialCapacity() {
        linkedList = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20_000_000; i++) {
            linkedList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Insert time = " + ((double) (end - start)) / 1000);
    }

    private static void insertAtRandomIndex() {
        List<Integer> randomIndices = new ArrayList<>(10_001);

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            randomIndices.add(random.nextInt(20_000_000));
        }

        long start = System.currentTimeMillis();
        for (int randomIndex : randomIndices) {
            linkedList.add(randomIndex, 0);
        }
        long end = System.currentTimeMillis();
        System.out.println("Random index inserts time = " + ((double) (end - start)) / 1000);
    }

    private static void sequencialReads() {
        long start = System.currentTimeMillis();
        for (Integer i : linkedList) {
            // do nothing
        }
        long end = System.currentTimeMillis();
        System.out.println("Read time  = " + ((double) (end - start)) / 1000);
    }

    private static void deletionAtRandomIndex() {
        List<Integer> randomIndices = new ArrayList<>(101);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            randomIndices.add(random.nextInt(20_000_000));
        }

        long start = System.currentTimeMillis();
        for (int randomIndex : randomIndices) {
            linkedList.remove(randomIndex);
        }
        long end = System.currentTimeMillis();
        System.out.println("Random index delete time = " + ((double) (end - start)) / 1000);
    }
}
