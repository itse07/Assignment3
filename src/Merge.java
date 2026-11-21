
public class Merge {

    /*
     * Merge Sort Algorithm
     *
     * Merge Sort is a divide-and-conquer sorting algorithm.
     *
     * It recursively divides the input array into smaller
     * subarrays until each subarray contains one element.
     *
     * The sorted subarrays are then merged together
     * to produce the final sorted array.
     *
     * Unlike Selection Sort and Bubble Sort, Merge Sort
     * maintains O(n log n) time complexity in all cases.
     *
     * Best Case Time: O(n log n).
     * Average Case Time: O(n log n).
     * Worst Case Time: O(n log n).
     * Auxiliary Space: O(n).
     */
    public static void mergeSort(int[] arr, int left, int right) {

        // Divide the array only if it has multiple elements.
        if (left < right) {

            // Find the middle index of the current subarray.
            int mid = left + (right - left) / 2;

            // Recursively sort the left half.
            mergeSort(arr, left, mid);

            // Recursively sort the right half.
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves.
            merge(arr, left, mid, right);
        }
    }

    /*
     * Merge Method
     *
     * Combines two previously sorted subarrays into
     * one sorted section of the original array.
     *
     * Temporary arrays are used to store the left
     * and right halves during the merging process.
     *
     * Elements from both halves are compared and
     * copied back into the original array in ascending order.
     */
    public static void merge(int[] arr, int left, int mid, int right) {

        // Calculate the sizes of the two subarrays.
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays for both halves.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy elements into the left temporary array.
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        // Copy elements into the right temporary array.
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Initialize indices for merging.
        int i = 0;
        int j = 0;
        int k = left;

        // Compare elements and merge them in ascending order.
        while (i < n1 && j < n2) {

            // Copy the smaller element into the original array.
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            // Move to the next position in the original array.
            k++;
        }

        // Copy any remaining elements from the left array.
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right array.
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /*
     * Generates arrays for experimental testing.
     *
     * Sorted arrays contain ascending integer values.
     * Reverse-sorted arrays contain descending integer values.
     *
     * The required array sizes are 5 and 100 elements.
     */
    public static int[] createArray(int size, boolean sorted) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            if (sorted) {
                arr[i] = i + 1;
            } else {
                arr[i] = size - i;
            }
        }

        return arr;
    }

    /*
     * Measures Merge Sort execution time.
     *
     * Each measurement repeats the sorting process
     * 10,000 times to obtain more stable timing values.
     *
     * Before each repetition, the original array is copied
     * to ensure that every sorting operation uses the same input.
     *
     * Note: The measured time includes array copying.
     *
     * The elapsed time is divided by the number of
     * repetitions and converted from nanoseconds
     * into microseconds.
     */
    public static double measureTime(int[] original) {
        int repetitions = 10000;
        int[] arr = new int[original.length];

        // Record the starting time.
        long start = System.nanoTime();

        for (int r = 0; r < repetitions; r++) {

            // Restore the original array before sorting.
            System.arraycopy(original, 0, arr, 0, original.length);

            // Execute Merge Sort.
            mergeSort(arr, 0, arr.length - 1);
        }

        // Record the ending time.
        long end = System.nanoTime();

        // Calculate average time in microseconds.
        return (end - start) / (double) repetitions / 1000.0;
    }

    /*
     * Tests Merge Sort using one array size and input order.
     *
     * The JVM is warmed up before collecting measurements.
     * Three measurement runs are performed.
     *
     * Their average is used as the final execution time.
     */
    public static void test(int size, boolean sorted) {
        int[] original = createArray(size, sorted);

        // JVM warm-up measurement.
        measureTime(original);

        double total = 0;

        // Perform three independent measurements.
        for (int run = 1; run <= 3; run++) {
            total += measureTime(original);
        }

        // Calculate the average execution time.
        double average = total / 3;

        String order = sorted ? "Sorted" : "Reverse Sorted";

        // Display the result in table format.
        System.out.printf(
            "%-10d %-18s %.6f%n",
            size, order, average
        );
    }

    /*
     * Main method.
     *
     * Runs Merge Sort using the four required cases:
     * Size 5 sorted, size 5 reverse sorted,
     * size 100 sorted, and size 100 reverse sorted.
     */
    public static void main(String[] args) {
        System.out.println("Merge Sort Performance Analysis");
        System.out.println("-------------------------------");
        System.out.println("Size       Order              Average Time (Microseconds)");

        test(5, true);
        test(5, false);
        test(100, true);
        test(100, false);
    }
}
