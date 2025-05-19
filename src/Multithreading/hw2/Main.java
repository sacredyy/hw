package Multithreading.hw2;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            Thread thread = new Thread(new FactorialTask(i));
            thread.start();
        }
    }
}
