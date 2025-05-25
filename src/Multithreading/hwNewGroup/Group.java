package Multithreading.hwNewGroup;

import java.util.*;

public class Group {
    private String groupName;
    private static int placesInGroup = 10;
    private static List<Student> studentsList;

    public Group(String groupName) {
        this.groupName = groupName;
        studentsList = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return studentsList;
    }

    public void addStudent(Student student) throws GroupOverflowException{
        if (studentsList.size() <= placesInGroup) {
            studentsList.add(student);
        } else {
            throw new GroupOverflowException("There is no space for new student");
        }
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException{
        if (lastName == null) {
            throw new IllegalArgumentException("Lastname can not be empty");
        }

        for (Student s : studentsList) {
            if (s.getLastName().equals(lastName)) {
                return s;
            }
        }
        throw new StudentNotFoundException("There is no students with lastname: " + lastName);
    }

    public boolean removeStudentByID(int id){
        boolean succes = studentsList.removeIf(student -> student.getId() == id);
        return succes;
    }

    public void sortStudentsByLastName(){
        studentsList.sort(new StudentsLastNameComparator());
    }

    public boolean hasDuplicate(){
        for (int i = 0; i < studentsList.size(); i++) {
            Student s1 = studentsList.get(i);
            for (int j = i + 1; j < studentsList.size(); j++) {
                Student s2 = studentsList.get(j);
                if (s1.equals(s2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;
        return groupName.equals(group.groupName) && studentsList.equals(group.studentsList);
    }

    @Override
    public int hashCode() {
        int result = groupName.hashCode();
        result = 31 * result + studentsList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "studentsList=" + studentsList +
                '}';
    }
}
