
public class Bubble {

    /*
     * Bubble Sort Algorithm
     *
     * This method sorts an integer array in ascending order
     * by repeatedly comparing adjacent elements.
     *
     * If two adjacent elements are in the wrong order,
     * their positions are exchanged.
     *
     * After each complete pass, the largest remaining
     * element moves to its correct position.
     *
     * An optimization is included using the swapped variable.
     * If no swaps occur during a pass, the array is already
     * sorted, so the algorithm terminates early.
     *
     * Best Case Time: O(n).
     * Average Case Time: O(n^2).
     * Worst Case Time: O(n^2).
     * Auxiliary Space: O(1).
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Perform passes through the array.
        for (int i = 0; i < n - 1; i++) {

            // Track whether any swap occurs during this pass.
            boolean swapped = false;

            // Compare adjacent elements in the unsorted section.
            for (int j = 0; j < n - i - 1; j++) {

                // Swap elements if they are in descending order.
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Record that a swap occurred.
                    swapped = true;
                }
            }

            // Stop early if the array is already sorted.
            if (!swapped) {
                break;
            }
        }
    }

    /*
     * Generates an integer array for testing.
     *
     * Sorted input contains values from 1 to size.
     * Reverse-sorted input contains values from size to 1.
     *
     * Both input orders are required to compare the
     * best-case and worst-case behavior of Bubble Sort.
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
     * Measures Bubble Sort execution time.
     *
     * Each measurement performs 10,000 repetitions.
     * The input array is restored before each repetition
     * so that every sorting operation receives the same data.
     *
     * System.nanoTime() records the elapsed time.
     *
     * Note: The measured time includes array copying.
     *
     * The final result represents average execution time
     * per repetition, expressed in microseconds.
     */
    public static double measureTime(int[] original) {
        int repetitions = 10000;
        int[] arr = new int[original.length];

        // Record the starting time.
        long start = System.nanoTime();

        for (int r = 0; r < repetitions; r++) {

            // Restore the original array.
            System.arraycopy(original, 0, arr, 0, original.length);

            // Execute Bubble Sort.
            bubbleSort(arr);
        }

        // Record the ending time.
        long end = System.nanoTime();

        // Convert average execution time to microseconds.
        return (end - start) / (double) repetitions / 1000.0;
    }

    /*
     * Tests one input case using three measurement runs.
     *
     * The JVM is warmed up before collecting results.
     * The three recorded times are added together,
     * and their arithmetic mean is calculated.
     */
    public static void test(int size, boolean sorted) {
        int[] original = createArray(size, sorted);

        // JVM warm-up measurement.
        measureTime(original);

        double total = 0;

        // Repeat the measurement three times.
        for (int run = 1; run <= 3; run++) {
            total += measureTime(original);
        }

        // Calculate the average execution time.
        double average = total / 3;

        String order = sorted ? "Sorted" : "Reverse Sorted";

        // Print the results in a readable format.
        System.out.printf(
            "%-10d %-18s %.6f%n",
            size, order, average
        );
    }

    /*
     * Main method.
     *
     * Tests Bubble Sort using four input cases:
     * two array sizes and two input orders.
     */
    public static void main(String[] args) {
        System.out.println("Bubble Sort Performance Analysis");
        System.out.println("--------------------------------");
        System.out.println("Size       Order              Average Time (Microseconds)");

        test(5, true);
        test(5, false);
        test(100, true);
        test(100, false);
    }
}
