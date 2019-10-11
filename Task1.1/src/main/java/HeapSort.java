
/**
 * @class HeapSort for implementation of Heap Sort
 *
 * Heap sort is a comparison-based sorting algorithm.
 *
 * Heap sort can be thought of as an improved selection sort:
 * like that algorithm, it divides its input into a sorted and an unsorted region,
 * and it iteratively shrinks the unsorted region by extracting the largest element
 * and moving that to the sorted region.
 *
 * The improvement consists of the use of a heap data structure rather
 * than a linear-time search to find the maximum.
 */

public class HeapSort
{
    /**
     * To sort array
     *
     * @param arr is an input array to be sorted
     */
    public static void sort(int arr[])
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    /**
     * To heapify a subtree rooted
     *
     * @param arr our array to sort
     * @param n size of heap
     * @param i node; index in arr
     */
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    /**
     * Starting point
     */
    public static void main(String[] args)
    {
        int array[] = {};
        sort(array);
        System.out.println(array[1]);
    }

}