package hw3;

public class Main {
    public static void main(String[] args) {
        Group it = new Group("it");
        Student student1 = new Student("Alex", "Wayne", Gender.MALE, 1);
        Student student3 = new Student("Robert", "Fox", Gender.MALE, 3);
        Student student4 = new Student("Nika", "Brane", Gender.FEMALE, 4);
        try {
            it.addStudent(student1);
            it.addStudent(student3);
            it.addStudent(student4);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }
        System.out.println(it.toString());
        Student student2 = new Student("Jon", "Weak", Gender.MALE, 2);
        System.out.println(it.removeStudentByID(1));
        try {
            it.searchStudentByLastName("Weak");
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }
    }
}
