package hw3;

import java.util.Scanner;

public class studentKeyboard {
    public static Student createStudentFromKeyboard(Group groupName) throws GroupOverflowException {
        String name;
        String lastName;
        Gender gender = null;
        int id = 0;
        try (Scanner sc = new Scanner(System.in)){
            System.out.print("Enter name of student: ");
            name = sc.nextLine();
            System.out.print("Enter lastname: ");
            lastName = sc.nextLine();
            while (gender == null) {
                System.out.print("Enter gender MALE/FEMALE: ");
                try {
                    gender = Gender.valueOf(sc.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid gender!");
                }
            System.out.print("Enter id: ");
            id = sc.nextInt();
            sc.nextLine();
        }
        Student student = new Student(name, lastName, gender, id);
        groupName.addStudent(student);
        return student;
        }
    }
}
