package Multithreading.hw5;

public class Main {
    public static void main(String[] args) {
        SearchService service = new SearchService("/home/kevin", "Main.java");
        service.startSearch();
    }
}
