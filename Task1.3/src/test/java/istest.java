

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class istest {

    @Test
    void testcase0() {
        String pattern = "a";
        String filePath = "src\\test\\java\\testcase0.txt";

        SubLine obj = new SubLine(pattern);
        int offset = obj.searchInFile(filePath);
        assertEquals(offset, -1);
    }

    @Test
    void testcase1() {
        String pattern = "デ";
        String filePath = "src\\test\\java\\testcase1.txt";

        SubLine obj = new SubLine(pattern);
        int offset = obj.searchInFile(filePath);

        assertEquals(offset, 10);
    }

    @Test
    void testcase2() {
        String pattern = "a";
        String filePath = "src\\test\\java\\testcase2.txt";

        SubLine obj = new SubLine(pattern);
        int offset = obj.searchInFile(filePath);
        assertEquals(offset, 143858);
    }

    @Test
    void testcase3() {
        String pattern = "пирог";
        String filePath = "src\\test\\java\\testcase3.txt";

        SubLine obj = new SubLine(pattern);
        int offset = obj.searchInFile(filePath);
        assertEquals(offset, 7);
    }

}