package Multithreading.hw3;


public class Port implements Runnable{

    private static final int maxDocPlace = 2;
    private static int busyDock = 0;
    private static final Object lock = new Object();
    private Ship ship;

    public Port(Ship ship) {
        this.ship = ship;
    }

    public  void doc(Ship s){
        int name = s.getName();
        try{
            synchronized(lock){
                while(busyDock >= maxDocPlace) {
                    System.out.println("Ship " + name + " wait for free place in doc...");
                    lock.wait();
                }
                busyDock += 1;
                System.out.println("Ship enter to doc: " + name);
            }

            while(s.getBoxes() > 0){
                s.unloading();
                ship.getBoxes();
                Thread.sleep(500);
            }

            System.out.println("Ship have no boxes");
            synchronized (lock) {
                busyDock -= 1;
                System.out.println("Ship left from doc" + name);
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        doc(ship);
    }
}
