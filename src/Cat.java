public class Cat extends Animal{
    String name;


    public Cat(String ration, String color, int weight, String name) {
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
    public String getVoice() {
        return "Meow";
    }

    @Override
    public void eat() {
        System.out.println("Cat eats");
    }

    @Override
    public void sleep() {
        System.out.println("Cat sleep");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", ration='" + ration + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
