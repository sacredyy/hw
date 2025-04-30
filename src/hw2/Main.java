package hw2;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Phone phone1 = new Phone("111");
        Phone phone2 = new Phone("222");
        Phone phone3 = new Phone("333");

        phone1.registerNum(network);
        phone3.registerNum(network);

        phone1.makeCall("222");
        phone3.makeCall("111");
    }
}