import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.paul.Assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentTest {

    @Test
    @DisplayName("80.0, 90.0, 70.0, -> 80.0")
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Assignment 1", 20);

        assignment.setScores(new ArrayList<>(Arrays.asList(80, 90, null, 70)));

        double expected = 80.0;
        double actual = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty scores list -> 0")
    public void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Assignment 2", 20);
        assignment.setScores(new ArrayList<>());

        double expected = 0.0;
        double actual = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, actual);
    }

}