package strimy.l;
import java.util.Scanner;

public class studentKeyboard {
    public static Student createStudentFromKeyboard(Group group) throws GroupOverflowException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of student: ");
        String name = sc.nextLine();

        System.out.print("Enter lastname: ");
        String lastName = sc.nextLine();

        Gender gender = null;
        while (gender == null) {
            System.out.print("Enter gender (MALE/FEMALE): ");
            try {
                gender = Gender.valueOf(sc.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender!");
            }
        }

        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            System.out.print("Enter age: ");
            try {
                age = Integer.parseInt(sc.nextLine());
                validAge = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid age!");
            }
        }

        int id = 0;
        boolean validId = false;
        while (!validId) {
            System.out.print("Enter id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
                validId = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID!");
            }
        }

        Student student = new Student(name, lastName, gender, age, id);
        group.addStudent(student);
        return student;
    }
}