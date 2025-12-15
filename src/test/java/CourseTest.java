import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.paul.Course;
import org.paul.Department;
import org.paul.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseTest {

    @Test
    @DisplayName("Assignment weights sum == 100 -> true")
    public void testIsAssignmentWeightValid1() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Programming 1", 3, dept);

        course.addAssignment("Assignment 1", 40);
        course.addAssignment("Assignment 2", 60);

        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Assignment weights sum != 100 -> false")
    public void testIsAssignmentWeightValid2() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Programming 1", 3, dept);

        course.addAssignment("Assignment 1", 50);
        course.addAssignment("Assignment 2", 40);

        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Register student successfully")
    public void testRegisterStudent1() {
        Department dept = new Department("Computer Science");
        Student student = new Student("Alice", Student.Gender.FEMALE, null, dept);
        Course course = new Course("Programming 1", 3, dept);

        boolean expected = true;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Register student already in course -> false")
    public void testRegisterStudentAlready2() {
        Department dept = new Department("Computer Science");
        Student student = new Student("Alice", Student.Gender.FEMALE, null, dept);
        Course course = new Course("Programming 1", 3, dept);

        // First registration
        course.registerStudent(student);

        // Attempt to register again
        boolean expected = false;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Calculate student's weighted average")
    public void testCalcStudentsAverage() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Programming 1", 3, dept);
        Student student = new Student("Alice", Student.Gender.FEMALE, null, dept);

        course.addAssignment("Assignment 1", 50);
        course.addAssignment("Assignment 2", 50);

        course.registerStudent(student);

        course.getAssignments().get(0).setScores(new ArrayList<>(List.of(80))); // 50% of 80
        course.getAssignments().get(1).setScores(new ArrayList<>(List.of(90))); // 50% of 90

        int[] expected = {85};
        int[] actual = course.calcStudentsAverage();

        Assertions.assertEquals(expected[0], actual[0]);
    }

}
