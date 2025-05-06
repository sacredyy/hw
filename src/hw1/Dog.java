package hw1;

public class Dog extends Animal{
    private String name;

    public Dog(String ration, String color, int weight, String name) {
        super(ration, color, weight);
        this.name = name;
    }

    public Dog(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sleep() {
        System.out.println("hw1.Dog " + this.name + " sleep");
    }

    @Override
    public void eat() {
        System.out.println("hw1.Dog " + this.name + " eat");
    }

    @Override
    public String getVoice() {
        return "woof";
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", ration='" + ration + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
