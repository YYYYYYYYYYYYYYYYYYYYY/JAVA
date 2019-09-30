public class istest {


    public static int[] makeArray (int size) {

        int [] result = new int [size];

        for (int i = 0; i < size; i++){
            result[i] = (int)(Math.random() * size);
        }

        return result;
    }


    public static boolean isSorted(int[] array) {

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1])
                return false;
        }

        return true;
    }


    public static void test() {

        int count = 0;
        for (int i = 100; i < 200; i++) {
            for (int j = 0; j < 10; j++) {

                int[] array = makeArray(i);

                HeapSort.sort(array);

                if (!isSorted(array)) {
                    System.out.println("U SHIT!");
                    count++;
                }
                else
                    System.out.println("TEST COMPLETE");
            }
        }
        if (count == 0)
            System.out.println("U NOT SHIT");
    }


}