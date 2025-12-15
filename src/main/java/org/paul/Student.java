package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;

    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = Util.toTitlecase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.studentId = "S" + String.format("%06d", nextId++);
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course){
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }

        return true;
    }

    public boolean dropCourse(Course course){
        if (!registeredCourses.contains(course)) {
            return false;
        }

        int idx = course.getRegisteredStudents().indexOf(this);

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        if (idx >= 0) {
            for (Assignment assignment : course.getAssignments()) {
                assignment.getScores().remove(idx);
            }
        }

        return true;
    }

    public Student(String studentId, String studentName, Gender gender, Address address, Department department, List<Course> registeredCourses) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public String toSimplifiedString() {
        return String.format(
                "Student[id=%s, name=%s, department=%s]",
                studentId,
                studentName,
                department != null ? department.getDepartmentName() : "N/A"
        );
    }

    public String toString() {
        String result = "Student {\n" +
                "  ID: " + studentId + "\n" +
                "  Name: " + studentName + "\n" +
                "  Gender: " + gender + "\n" +
                "  Address: " + address + "\n" +
                "  Department: " +
                (department != null ? department.getDepartmentName() : "N/A") + "\n" +
                "  Registered Courses:\n";

        if (registeredCourses.isEmpty()) {
            result += "None\n";
        } else {
            for (Course course : registeredCourses) {
                result += " - " + course.toSimplifiedString() + "\n";
            }
        }
        result += "}";

        return result;
    }

    public enum Gender {
        MALE, FEMALE
    }

}
