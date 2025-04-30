package hw2;

public class Phone {
    private String number;
    private Network network;
    private boolean isRegistered;

    public Phone(String number) {
        this.number = number;
        this.isRegistered = false;
    }

    public void registerNum(Network network) {
        if (network.register(this.number)) {
            this.network = network;
            this.isRegistered = true;
            System.out.println("Number " + number + " registered successfully");
        } else {
            System.out.println("Number " + number + " already registered or network full");
        }
    }

    public void makeCall(String targetNumber) {
        if (!isRegistered) {
            System.out.println("Error: phone " + number + " not registered in network");
            return;
        }
        if (!network.isRegistered(targetNumber)) {
            System.out.println("Error: target number " + targetNumber + " not found");
            return;
        }
        System.out.println(number + " calling " + targetNumber);
    }
}