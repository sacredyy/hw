package Multithreading.hw2;

import java.math.BigInteger;

public class FactorialTask implements Runnable{
    private int threadNum;

    public FactorialTask(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        BigInteger resultFinal = calcFaktorial(threadNum);
        System.out.println("Factorial of " + threadNum + " = " + resultFinal);
    }

    private BigInteger calcFaktorial(int n){
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
