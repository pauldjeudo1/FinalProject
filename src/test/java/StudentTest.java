import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.paul.Course;
import org.paul.Department;
import org.paul.Student;

public class StudentTest {

    @Test
    @DisplayName("Register course successfully")
    public void testRegisterCourse1() {
        Department dept = new Department("Computer Science");
        Student student = new Student("Alice", Student.Gender.FEMALE, null, dept);
        Course course = new Course("Programming 1", 3, dept);

        boolean expected = true;
        boolean actual = student.registerCourse(course);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(1, student.getRegisteredCourses().size());
        Assertions.assertEquals(course, student.getRegisteredCourses().get(0));
        Assertions.assertEquals(1, course.getRegisteredStudents().size());
        Assertions.assertEquals(student, course.getRegisteredStudents().get(0));
    }

    @Test
    @DisplayName("Register same course twice -> false")
    public void testRegisterCourse2() {
        Department dept = new Department("Computer Science");
        Student student = new Student("Alice", Student.Gender.FEMALE, null, dept);
        Course course = new Course("Programming 1", 3, dept);

        student.registerCourse(course);
        boolean expected = false;
        boolean actual = student.registerCourse(course);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(1, student.getRegisteredCourses().size());
        Assertions.assertEquals(1, course.getRegisteredStudents().size());
    }

    @Test
    @DisplayName("Drop registered course successfully")
    public void testDropCourse3() {
        Department dept = new Department("Computer Science");
        Student student = new Student("Alice", Student.Gender.FEMALE, null, dept);
        Course course = new Course("Programming 1", 3, dept);

        student.registerCourse(course);

        boolean expected = true;
        boolean actual = student.dropCourse(course);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(0, student.getRegisteredCourses().size());
        Assertions.assertEquals(0, course.getRegisteredStudents().size());
    }

    @Test
    @DisplayName("Drop unregistered course -> false")
    public void testDropCourse4() {
        Department dept = new Department("Computer Science");
        Student student = new Student("Alice", Student.Gender.FEMALE, null, dept);
        Course course = new Course("Programming 1", 3, dept);

        boolean expected = false;
        boolean actual = student.dropCourse(course);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(0, student.getRegisteredCourses().size());
        Assertions.assertEquals(0, course.getRegisteredStudents().size());
    }
}
