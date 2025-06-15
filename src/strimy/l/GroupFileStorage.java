package strimy.l;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class GroupFileStorage {
    public static void saveGroupToCSV(Group group) throws IOException {
        List<Student> students = group.getStudents();

        StringBuilder csvCon = new StringBuilder();

        for (Student student : students) {
            if (student != null) {
                csvCon.append(student.getName()).append(';')
                        .append(student.getLastName()).append(';')
                        .append(student.getGender()).append(';')
                        .append(student.getAge()).append(';')
                        .append(student.getId()).append('\n');
            }
        }
        String fileName = group.getGroupName() + ".csv";
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(csvCon.toString());
        }
    }

    public static Group loadGroupFromCSV(Group newGroup, File file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String tempLine = sc.nextLine();
                newGroup.addStudent(loadSutdent(tempLine));
            }
        } catch (GroupOverflowException e) {
            throw new RuntimeException(e);
        }
        return newGroup;
    }

    private static Student loadSutdent(String svc) {
        String[] iStudent = svc.split(";");
        String name = iStudent[0];
        String lastName = iStudent[1];
        Gender gen = Gender.valueOf(iStudent[2]);
        int age = Integer.valueOf(iStudent[3]);
        int id = Integer.valueOf(iStudent[4]);
        return new Student(name, lastName, gen, age, id);
    }

    public static File findFileByGroupName(String groupName, File workFolder) {
        File[] files = workFolder.listFiles();
        File file = null;
        String targetFile = groupName + ".csv";
        for (int i = 0; i < files.length; i++) {
            if (files[i] != null) {
                if (files[i].isFile() && files[i].getName().equals(targetFile)) {
                    file = files[i];
                }
            }
        }
        return file;
    }
}