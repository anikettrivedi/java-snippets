package performance.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListPerformance {

    private static List<Integer> arrayList;

    public static void main(String[] args) {
        System.out.println("ArrayList");
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

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20_000_000; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Insert time without initial capacity = " + ((double) (end - start)) / 1000);
    }

    private static void insertWithInitialCapacity() {
        arrayList = new ArrayList<>(20_000_001);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20_000_000; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Insert time with initial capacity = " + ((double) (end - start)) / 1000);
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
        System.out.println("Random index inserts time = " + ((double) (end - start)) / 1000);
    }

    private static void sequencialReads(){
        long start = System.currentTimeMillis();
        for (Integer i : arrayList) {
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
            arrayList.remove(randomIndex);
        }
        long end = System.currentTimeMillis();
        System.out.println("Random index delete time = " + ((double) (end - start)) / 1000);
    }
}
