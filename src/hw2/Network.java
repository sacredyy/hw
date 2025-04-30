package hw2;

public class Network {
    private String[] registeredNumbers;
    private int count;

    public Network() {
        this.registeredNumbers = new String[10];
        this.count = 0;
    }

    public boolean isRegistered(String number) {
        for (int i = 0; i < count; i++) {
            if (registeredNumbers[i].equals(number)) {
                return true;
            }
        }
        return false;
    }

    public boolean register(String number) {
        if (isRegistered(number)) {
            return false;
        }
        if (count >= registeredNumbers.length) {
            System.out.println("Network is full");
            return false;
        }
        registeredNumbers[count++] = number;
        return true;
    }
}