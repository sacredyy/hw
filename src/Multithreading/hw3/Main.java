package Multithreading.hw3;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Ship ship = new Ship(i);
            Port portTask = new Port(ship);
            Thread thr = new Thread(portTask);
            thr.start();
        }
    }
}
