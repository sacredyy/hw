package hw3;

import java.util.Arrays;

public class Group {
    String groupName;
    Student[] students;

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

    @Override
    public String toString() {
        String res = "Students in group: " + System.lineSeparator();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null){
                res += students[i];
            }
        }
        return res;
    }
}
