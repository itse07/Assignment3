
public class Selection {

    /*
     * Selection Sort Algorithm
     *
     * This method sorts an integer array in ascending order.
     *
     * The algorithm divides the array into two parts:
     * 1. A sorted part at the beginning.
     * 2. An unsorted part containing the remaining elements.
     *
     * In each iteration, it finds the smallest element in the
     * unsorted part and places it at the current position.
     *
     * Time Complexity: O(n^2) in all cases.
     * Auxiliary Space: O(1).
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Move the boundary of the sorted part forward.
        for (int i = 0; i < n - 1; i++) {

            // Assume the current element is the minimum.
            int minIndex = i;

            // Search for the smallest remaining element.
            for (int j = i + 1; j < n; j++) {

                // Update the minimum index when needed.
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the current element.
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /*
     * Creates an array of the requested size.
     *
     * If sorted is true, the array contains ascending values.
     * If sorted is false, the array contains descending values.
     *
     * This allows testing the algorithm with different
     * input orders while keeping the array size unchanged.
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
     * Measures the average execution time of Selection Sort.
     *
     * The algorithm is repeated 10,000 times to reduce
     * the effect of timer resolution on small inputs.
     *
     * Before each sorting operation, the original array
     * is copied to restore the same input order.
     *
     * Note: Array copying is included in the measured time.
     *
     * System.nanoTime() measures elapsed time in nanoseconds.
     * The result is divided by the number of repetitions
     * and converted into microseconds.
     */
    public static double measureTime(int[] original) {
        int repetitions = 10000;
        int[] arr = new int[original.length];

        // Start measuring execution time.
        long start = System.nanoTime();

        for (int r = 0; r < repetitions; r++) {

            // Restore the original input before sorting.
            System.arraycopy(original, 0, arr, 0, original.length);

            // Execute Selection Sort.
            selectionSort(arr);
        }

        // Stop measuring execution time.
        long end = System.nanoTime();

        // Calculate average time per repetition in microseconds.
        return (end - start) / (double) repetitions / 1000.0;
    }

    /*
     * Tests Selection Sort for one array size and input order.
     *
     * A warm-up measurement is performed before collecting
     * the results to allow the JVM to optimize execution.
     *
     * Three measurement runs are performed, and their
     * average is calculated as required by the assignment.
     */
    public static void test(int size, boolean sorted) {
        int[] original = createArray(size, sorted);

        // Warm up the Java Virtual Machine.
        measureTime(original);

        double total = 0;

        // Perform three independent measurement runs.
        for (int run = 1; run <= 3; run++) {
            double time = measureTime(original);
            total += time;
        }

        // Calculate the average of the three runs.
        double average = total / 3;

        String order = sorted ? "Sorted" : "Reverse Sorted";

        // Display the result in a formatted table.
        System.out.printf(
            "%-10d %-18s %.6f%n",
            size, order, average
        );
    }

    /*
     * Main method.
     *
     * Executes the four required test cases:
     * 1. Size 5, sorted.
     * 2. Size 5, reverse sorted.
     * 3. Size 100, sorted.
     * 4. Size 100, reverse sorted.
     */
    public static void main(String[] args) {
        System.out.println("Selection Sort Performance Analysis");
        System.out.println("-----------------------------------");
        System.out.println("Size       Order              Average Time (Microseconds)");

        test(5, true);
        test(5, false);
        test(100, true);
        test(100, false);
    }
}
