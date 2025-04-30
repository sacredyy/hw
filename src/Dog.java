public class Dog extends Animal{
    String name;

    public Dog(String ration, String color, int weight, String name) {
        super(ration, color, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sleep() {
        System.out.println("Dog " + this.name + " sleep");
    }

    @Override
    public void eat() {
        System.out.println("Dog " + this.name + " eat");
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
