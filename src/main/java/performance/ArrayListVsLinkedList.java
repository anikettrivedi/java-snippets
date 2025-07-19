package performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayListVsLinkedList {

    private static List<Integer> arrayList;
    private static List<Integer> linkedList;

    public static void main(String[] args) {
        System.out.println("*****************");
        insertWithoutInitialCapacity();
        System.out.println("*****************");
        insertWithInitialCapacity();
        System.out.println("*****************");
        insertAtRandomIndex();
        System.out.println("*****************");
        sequencialReads();
        System.out.println("*****************");
        deletionAtRandomIndex();
    }

    private static void insertWithoutInitialCapacity() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20_000_000; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList insert time without initial capacity = " + ((double) (end - start)) / 1000);

        start = System.currentTimeMillis();
        for (int i = 0; i < 20_000_000; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList insert time = " + ((double) (end - start)) / 1000);
    }

    private static void insertWithInitialCapacity() {
        arrayList = new ArrayList<>(20_000_001);
        linkedList = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20_000_000; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList insert time with initial capacity = " + ((double) (end - start)) / 1000);

        start = System.currentTimeMillis();
        for (int i = 0; i < 20_000_000; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList insert time = " + ((double) (end - start)) / 1000);
    }

    private static void insertAtRandomIndex() {
        List<Integer> randomIndices = new ArrayList<>(10_001);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            randomIndices.add(random.nextInt(20_000_000));
        }

        long start = System.currentTimeMillis();
        for (int randomIndex : randomIndices) {
            arrayList.add(randomIndex, 0);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList random index inserts time = " + ((double) (end - start)) / 1000);

        start = System.currentTimeMillis();
        for (int randomIndex : randomIndices) {
            linkedList.add(randomIndex, 0);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList random index inserts time = " + ((double) (end - start)) / 1000);
    }

    private static void sequencialReads(){
        long start = System.currentTimeMillis();
        for (Integer i : arrayList) {
            // do nothing
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList read time  = " + ((double) (end - start)) / 1000);

        start = System.currentTimeMillis();
        for (Integer i : linkedList) {
            // do nothing
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList read time = " + ((double) (end - start)) / 1000);
    }

    private static void deletionAtRandomIndex() {

        List<Integer> randomIndices = new ArrayList<>(10_001);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            randomIndices.add(random.nextInt(20_000_000));
        }

        long start = System.currentTimeMillis();
        for (int randomIndex : randomIndices) {
            arrayList.remove(randomIndex);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList random index delete time = " + ((double) (end - start)) / 1000);

        start = System.currentTimeMillis();
        for (int randomIndex : randomIndices) {
            linkedList.remove(randomIndex);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList random index delete time = " + ((double) (end - start)) / 1000);
    }
}
