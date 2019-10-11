import org.junit.Test;
import org.junit.Assert;

public class istest {

    /**
     * To create random-filled array
     * @param size is a size of array to create
     * @return created array
     */
    public static int[] makeArray (int size) {

        int [] result = new int [size];

        for (int i = 0; i < size; i++){
            result[i] = (int)(Math.random() * size);
        }

        return result;
    }

    /**
     * To check if array sorted or not
     *
     * @param array input array
     * @return true if array sorted; false otherwise
     */
    public static boolean isSorted(int[] array) {

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1])
                return false;
        }
        return true;
    }


    @Test
    public void test() {

        int sorted = 1;
        for (int i = 100; i < 200; i++) {
            for (int j = 0; j < 10; j++) {

                int[] array = makeArray(i);

                HeapSort.sort(array);

                Assert.assertTrue(isSorted(array));
            }
        }

    }

}