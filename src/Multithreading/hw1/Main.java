package Multithreading.hw1;



public class Main {
    public static void main(String[] args) {
        int[] num = new int[10_000_000];
        CalculateService.generateMasive(num);

        CalculateService main = new CalculateService(0, 10000000, num);


        CalculateService cs1 = new CalculateService(0, 2_500_000, num);
        CalculateService cs2 = new CalculateService(2_500_001, 5_000_000, num);
        CalculateService cs3 = new CalculateService(5_000_001, 7_500_000, num);
        CalculateService cs4 = new CalculateService(7_500_001, 10_000_000, num);

        Thread thrMain = new Thread(main);
        Thread thr1 = new Thread(cs1);
        Thread thr2 = new Thread(cs2);
        Thread thr3 = new Thread(cs3);
        Thread thr4 = new Thread(cs4);

        thrMain.setDaemon(true);
        thrMain.start();

        thr1.start();
        thr2.start();
        thr3.start();
        thr4.start();

        try {
            thr1.join();
            thr2.join();
            thr3.join();
            thr4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long multiSum = cs1.getSumRes() + cs2.getSumRes() + cs3.getSumRes() + cs4.getSumRes();
        System.out.println("Last processed index: " + main.getLastProcessedIndex());
        System.out.println("result = " + multiSum);
    }
}
