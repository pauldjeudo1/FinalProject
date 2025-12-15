import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.paul.Department;

public class DepartmentTest {

    @Test
    @DisplayName("Computer Science -> true")
    public void testIsDepartmentNameValid1() {
        String name = "Computer Science";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(name);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("CS101 -> false")
    public void testIsDepartmentNameValid2() {
        String departmentName = "CS101";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("'Math&Physics' -> false")
    public void testIsDepartmentNameValid3() {
        String departmentName = "Math&Physics";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("'' -> false")
    public void testIsDepartmentNameValid4() {
        String departmentName = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }

}
