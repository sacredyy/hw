package strimy.l;

import java.util.Objects;

public class Student extends Human {
    private int id = 0;
    private String groupName;

    public Student(String name, String lastName, Gender gender, int age, int id) {
        super(name, lastName, gender, age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return getId() == student.getId() && Objects.equals(getGroupName(), student.getGroupName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getGroupName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", gender=" + getGender() +
                ", age=" + getAge() +
                '}';
    }
}