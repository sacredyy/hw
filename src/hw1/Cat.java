package hw1;

public class Cat extends Animal{
    private String name;


    public Cat(String ration, String color, int weight, String name) {
        super(ration, color, weight);
        this.name = name;
    }

    public Cat(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getVoice() {
        return "Meow";
    }

    @Override
    public void eat() {
        System.out.println("hw1.Cat eats");
    }

    @Override
    public void sleep() {
        System.out.println("hw1.Cat sleep");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", ration='" + getRation() + '\'' +
                ", color='" + getColor() + '\'' +
                ", weight=" + getWeight() +
                '}';
    }
}
