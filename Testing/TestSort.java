import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void testSort() {
        String[] input = new String[]{"i", "have", "an", "egg"};
        String[] expected = new String[]{"an", "egg", "have", "i"};
        Sort.sort(input);
        assertArrayEquals(input, expected);

        String[] input2 = new String[]{"can", "you", "eat", "potatoes"};
        String[] expected2 = new String[]{"can", "eat", "potatoes", "you"};
        Sort.sort(input2);
        assertArrayEquals(input2, expected2);

    }
    @Test
    public void testFindSmallest() {
        String[] input = new String[]{"i", "have", "an", "egg"};
        int expected = 2;
        int actual = Sort.findSmallest(input, 0);
        assertEquals(actual, expected);

        String[] input2 = new String[]{"an", "have", "i", "egg"};
        int expected2 = 3;
        int actual2 = Sort.findSmallest(input2, 1);
        assertEquals(actual,expected);
    }




}