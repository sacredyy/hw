package hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group {
    private String groupName;
    private static Student[] students;

    public Group(String groupName) {
        this.groupName = groupName;
        students = new Student[10];
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent(Student student) throws GroupOverflowException{
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                students[i].setGroupName(this.groupName);
                return;
            }
        }
        throw new GroupOverflowException("There is no space for new student");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException{
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null){
                if (students[i].getLastName().equals(lastName)){
                    return students[i];
                }
            }
        }
        throw new StudentNotFoundException("There is no students with lastname: " + lastName);
    }

    public boolean removeStudentByID(int id){
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id){
                    students[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public void sortStudentsByLastName(){
        Arrays.sort(students, Comparator.nullsFirst(new StudentsLastNameComparator()));
    }

    public boolean hasDuplicate(){
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                for (int j = i + 1; j <students.length; j++) {
                    if (students[j] != null && students[i].equals(students[j])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Group group)) return false;
        return Objects.equals(groupName, group.groupName) && Objects.deepEquals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, Arrays.hashCode(students));
    }

    @Override
    public String toString() {
        String res = "Students in group: " + System.lineSeparator();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null){
                res += students[i] + "\n";
            }
        }
        return res;
    }
}
