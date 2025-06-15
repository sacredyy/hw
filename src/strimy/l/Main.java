package strimy.l;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Oscar", "Piastri", Gender.FEMALE, 24, 7),
                new Student("Alex", "Wayne", Gender.MALE, 20, 1),
                new Student("Robert", "Fox", Gender.MALE, 21, 3),
                new Student("Bruice", "Hamilton", Gender.FEMALE, 23, 5),
                new Student("Oscar", "Piastri", Gender.FEMALE, 24, 7),
                new Student("Nika", "Brane", Gender.FEMALE, 22, 4),
        };
        List<Student> studentList = Arrays.stream(students)
                .filter(s -> s.getAge() > 20)
                .sorted((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()))
                .collect(Collectors.toList());
        System.out.println(studentList);
    }
}
