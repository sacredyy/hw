package Multithreading.hw1;

import java.util.Random;

public class CalculateService implements Runnable {
    private int start;
    private int end;
    private int[] numbers;
    private long sumRes;
    private int lastProcessedIndex;

    public CalculateService(int start, int end, int[] numbers) {
        this.start = start;
        this.end = end;
        this.numbers = numbers;
    }

    public long calcSum() {
        long res = 0;
        for (int i = start; i < end; i++) {
            res += numbers[i];
            lastProcessedIndex = i;
        }
        return res;
    }

    public static int[] generateMasive(int[] num){
        Random random = new Random();
        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(1000);
        }
        return num;
    }


    public long getSumRes() {
        return sumRes;
    }

    public int getLastProcessedIndex() {
        return lastProcessedIndex;
    }

    @Override
    public void run() {
        sumRes = calcSum();
    }
}
