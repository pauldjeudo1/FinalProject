import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.paul.Util;

public class UtilTest {

    @Test
    @DisplayName("paul DJEUDO -> Paul Djeudo")
    public void testToTitleCase1() {
        String input = "paul DJEUDO";
        String expected = "Paul Djeudo";
        String actual = Util.toTitlecase(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("computer science and math -> Computer Science And Math")
    public void testToTitleCase2() {
        String input = "computer science and math";
        String expected = "Computer Science And Math";
        String actual = Util.toTitlecase(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("hEALth sCIENCe -> Health Science")
    public void testToTitleCase3() {
        String input = "hEALth sCIENCe";
        String expected = "Health Science";
        String actual = Util.toTitlecase(input);
        Assertions.assertEquals(expected, actual);
    }

}
