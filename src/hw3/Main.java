package hw3;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Group it = new Group("it");
        Group it2 = new Group("it2");
        Student student1 = new Student("Alex", "Wayne", Gender.MALE, 1);
        Student student3 = new Student("Robert", "Fox", Gender.MALE, 3);
        Student student4 = new Student("Nika", "Brane", Gender.FEMALE, 4);
        Student student5 = new Student("Bruice", "Hamilton", Gender.FEMALE, 5);
        Student student6 = new Student("Entoni", "Leclerk", Gender.FEMALE, 6);
        Student student7 = new Student("Oscar", "Piastri", Gender.FEMALE, 7);
        try {
            studentKeyboard.createStudentFromKeyboard(it);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }
        try {
            it.addStudent(student1);
            it.addStudent(student3);
            it.addStudent(student4);
            it.addStudent(student5);
            it.addStudent(student6);
            it.addStudent(student7);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }

        System.out.println(it.removeStudentByID(1));
        try {
            it.searchStudentByLastName("Weak");
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(it.toString());
        it.sortStudentsByLastName();
        System.out.println(it.toString());
        try {
            GroupFileStorage.saveGroupToCSV(it);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File fileGroup = new File("it.csv");
        try {
            System.out.println(GroupFileStorage.loadGroupFromCSV(it2, fileGroup));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        File workFolder = new File("/home/kevin/Documents/IdeaProjects/hw");
        File filex = GroupFileStorage.findFileByGroupName("zxc", workFolder);
        System.out.println(filex);
    }
}
