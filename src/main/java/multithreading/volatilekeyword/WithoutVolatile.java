package multithreading.volatilekeyword;

public class WithoutVolatile {

    public static final int NO_OF_ITERATIONS = 100_000;

    private static int counterOne = 0;
    private static int counterTwo = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread incrementingThreadOne = new Thread(() -> {
            for (int i = 0; i < NO_OF_ITERATIONS; i++) {
                counterOne++;
                counterTwo++;
            }
        });

        Thread checkerThread = new Thread(() -> {
            for (int i = 0; i < NO_OF_ITERATIONS; i++) {
                if (counterTwo > counterOne) {
                    System.out.println("CounterTwo > CounterOne! Data Race Detected!");
                }
            }
        });

        incrementingThreadOne.start();
        checkerThread.start();

        incrementingThreadOne.join();
        checkerThread.join();

    }

}
