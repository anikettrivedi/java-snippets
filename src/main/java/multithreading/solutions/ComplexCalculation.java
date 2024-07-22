package multithreading.solutions;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(
            BigInteger base1,
            BigInteger power1,
            BigInteger base2,
            BigInteger power2
    ) throws InterruptedException {
        PowerCalculatingThread t1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread t2 = new PowerCalculatingThread(base2, power2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return t1.getResult().add(t2.getResult());
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            BigInteger i = BigInteger.ONE;
            while (!i.equals(this.power.add(BigInteger.ONE))) {
                this.result = result.multiply(this.base);
                i = i.add(BigInteger.ONE);
            }
        }

        public BigInteger getResult() {
            return result;
        }
    }
}