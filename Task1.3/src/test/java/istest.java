import org.junit.Test;
import org.junit.Assert;
import sun.nio.cs.UTF_8;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class istest {

    @Test
    public void testcase0() throws UnsupportedEncodingException{

        String text = "bla bla bla bla";
        String subline = "bla";
        int[] out = {5, 0, 4, 8, 12};
        int[] ans = SubLine.search(text, subline);
        for (int i = 1; i < ans[0]; i++) {

            Assert.assertTrue(ans[i] == out[i]);
        }
    }

    @Test
    public void testcase1() throws UnsupportedEncodingException{

        String text = "bbbb";
        String subline = "b";
        int[] out = {5, 0, 1, 2, 3};
        int[] ans = SubLine.search(text, subline);
        for (int i = 1; i < ans[0]; i++) {

            Assert.assertTrue(ans[i] == out[i]);
        }
    }

    @Test
    public void testcase2() throws UnsupportedEncodingException{

        String text = "  ";
        String subline = " ";
        int[] out = {3, 0, 1};
        int[] ans = SubLine.search(text, subline);
        for (int i = 1; i < ans[0]; i++) {

            Assert.assertTrue(ans[i] == out[i]);
        }
    }

    @Test
    public void testcase3() throws UnsupportedEncodingException {

        String text = "aуa"; // latin y, kiril a
        String subline = "a"; // kiril a

        int[] out = {3, 0, 2};
        int[] ans = SubLine.search(text, subline);
        for (int i = 1; i < ans[0]; i++) {
            Assert.assertTrue(ans[i] == out[i]);
        }
    }

    @Test
    public void testcase4() throws UnsupportedEncodingException{

        String text = "Я хочу пирог!\n";
        String subline = "пирог";
        int[] out = {2, 7};
        int[] ans = SubLine.search(text, subline);
        for (int i = 1; i < ans[0]; i++) {
            Assert.assertTrue(ans[i] == out[i]);
        }
    }

    @Test
    public void testcase5() throws UnsupportedEncodingException{

        String text = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        String subline = "bb";
        int[] ans = SubLine.search(text, subline);
        for (int i = 1; i < ans[0] - 1; i++) {
            Assert.assertTrue(ans[i]+2 == ans[i]+2);
        }
    }

    @Test
    public void testcase6() throws UnsupportedEncodingException {
        //System.setProperty("file.encoding","UTF-8");

        String subline = "kkk";

        String filePath = "src\\main\\java\\input.txt";

        int[] out =  {5};

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

            stream.forEach(line -> {
                try {
                    int[] ans = SubLine.search(line, subline);
                    for (int i = 1; i < ans[0] - 1; i++) {
                        Assert.assertTrue(ans[i] == out[i]);
                    }
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}