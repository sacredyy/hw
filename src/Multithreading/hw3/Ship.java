package Multithreading.hw3;

public class Ship {
    private int name;
    private int boxes = 10;

    public Ship(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getBoxes() {
        return boxes;
    }

    public void setBoxes(int boxes) {
        this.boxes = boxes;
    }

    public void unloading(){
        System.out.println("The ship " + name +  " unboard 1 box, box left: " + boxes);
        this.boxes -= 1;
    }
}
