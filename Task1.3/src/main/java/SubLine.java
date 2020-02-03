import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Class finds the first occurrence of a pattern string in a text string.
 *
 * The implementation uses the Knuth–Morris–Pratt string-searching algorithm. The complexity of the overall algorithm
 * is O(n + m) in the worst case, where n is the length of the text, and m is the length
 * of the pattern.
 */
public class SubLine {

    private static final String UTF_8 = "\uFEFF";
    private static final int BLOCK = 8192;
    private final int[] next;
    private final String pattern;



    /**
     * Creates Knuth–Morris–Pratt NFA from the given pattern.
     *
     * @param  pattern   the pattern string.
     */
    public SubLine(String pattern) {
        this.pattern = pattern;
        int patternLength = pattern.length();
        next = new int[patternLength];

        int j = -1;
        for (int i = 0; i < patternLength; i++) {
            if (i == 0) {
                next[i] = -1;
            } else if (pattern.charAt(i) == pattern.charAt(j)) {
                next[i] = next[j];
            } else {
                next[i] = j;
            }

            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }

            j++;
        }
    }



    /**
     *
     * @param   filePath   the path to the file that contains the text string.
     * @return  the index of the first occurrence of the pattern in the given text, or -1 if the pattern string
     * was not found at all.
     */
    public int searchInFile(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath);
             Reader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"))) {

            StringBuilder string = new StringBuilder();
            int textBlock = BLOCK;
            char[] chars = new char[textBlock];
            int count;
            int acc = textBlock;
            int offset = 0;

            while (inputStreamReader.read(chars) > 0) {
                string.append(chars);
                Arrays.fill(chars, '\u0000');

                if (removeUTF8BOM(string)) {
                    char[] c = new char[1];
                    if (inputStreamReader.read(c) > 0) {
                        string.append(c);
                    } else {
                        textBlock--;
                        acc--;
                    }
                }

                count = search(string.toString());

                if (count >= textBlock && count % acc == 1) {
                    acc += textBlock;
                } else if (count >= textBlock && count % acc == 0) {
                    string.setLength(0);
                    offset += acc;
                    acc = textBlock;
                } else {
                    return offset + count;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }



    private int search(String text) {
        int textLength = text.length();
        int patternLength = pattern.length();

        int i, j;
        for (i = 0, j = 0; i < textLength && j < patternLength; i++) {
            while (j >= 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }

            j++;
        }

        if (j == patternLength) {
            return i - patternLength;
        }

        if (pattern.charAt(j - 1 > 0 ? j - 1 : 0) == text.charAt(text.length() - 1)) {
            return textLength + 1;
        }

        return textLength;
    }



    private boolean removeUTF8BOM(StringBuilder string) {
        if (string.toString().startsWith(UTF_8)) {
            string.delete(0, 1);
            return true;
        }

        return false;
    }
}