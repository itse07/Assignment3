
public class Quick {

    /*
     * Quick Sort Algorithm
     *
     * Quick Sort uses the divide-and-conquer approach.
     *
     * It selects a pivot element and partitions the array
     * so that smaller elements appear before the pivot
     * and larger elements appear after it.
     *
     * The algorithm then recursively sorts the two
     * subarrays created by the partitioning process.
     *
     * In this implementation, the last element is
     * always selected as the pivot.
     *
     * Best Case Time: O(n log n).
     * Average Case Time: O(n log n).
     * Worst Case Time: O(n^2).
     *
     * Average Auxiliary Space: O(log n).
     * Worst Auxiliary Space: O(n).
     */
    public static void quickSort(int[] arr, int low, int high) {

        // Continue only if the subarray has multiple elements.
        if (low < high) {

            // Partition the array and obtain the pivot position.
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before the pivot.
            quickSort(arr, low, pivotIndex - 1);

            // Recursively sort elements after the pivot.
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /*
     * Partition Method
     *
     * The last element is selected as the pivot.
     *
     * Elements smaller than the pivot are moved
     * toward the beginning of the subarray.
     *
     * Finally, the pivot is placed in its correct
     * sorted position, and its index is returned.
     */
    public static int partition(int[] arr, int low, int high) {

        // Select the last element as the pivot.
        int pivot = arr[high];

        // Track the boundary of smaller elements.
        int i = low - 1;

        // Compare each element with the pivot.
        for (int j = low; j < high; j++) {

            // Move smaller elements to the left side.
            if (arr[j] < pivot) {
                i++;

                // Swap the current element into the left partition.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot after all smaller elements.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the final pivot position.
        return i + 1;
    }

    /*
     * Creates test arrays in ascending or descending order.
     *
     * These input orders are important because selecting
     * the last element as pivot produces highly unbalanced
     * partitions for sorted and reverse-sorted arrays.
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
     * Measures Quick Sort execution time.
     *
     * The algorithm is repeated 10,000 times.
     * The original array is copied before each repetition.
     *
     * The total elapsed time is measured in nanoseconds
     * using System.nanoTime().
     *
     * Note: Array copying is included in the timing.
     *
     * The result is converted into average microseconds
     * per sorting repetition.
     */
    public static double measureTime(int[] original) {
        int repetitions = 10000;
        int[] arr = new int[original.length];

        // Start timing.
        long start = System.nanoTime();

        for (int r = 0; r < repetitions; r++) {

            // Restore the original input order.
            System.arraycopy(original, 0, arr, 0, original.length);

            // Execute Quick Sort on the complete array.
            quickSort(arr, 0, arr.length - 1);
        }

        // Stop timing.
        long end = System.nanoTime();

        // Return average time in microseconds.
        return (end - start) / (double) repetitions / 1000.0;
    }

    /*
     * Performs three timing measurements for one test case.
     *
     * A JVM warm-up is performed first.
     * The average of the three runs is then calculated.
     */
    public static void test(int size, boolean sorted) {
        int[] original = createArray(size, sorted);

        // Warm up the JVM.
        measureTime(original);

        double total = 0;

        // Perform three independent measurement runs.
        for (int run = 1; run <= 3; run++) {
            total += measureTime(original);
        }

        // Calculate the average time.
        double average = total / 3;

        String order = sorted ? "Sorted" : "Reverse Sorted";

        // Display the measured result.
        System.out.printf(
            "%-10d %-18s %.6f%n",
            size, order, average
        );
    }

    /*
     * Main method.
     *
     * Executes Quick Sort on the four required test cases.
     */
    public static void main(String[] args) {
        System.out.println("Quick Sort Performance Analysis");
        System.out.println("-------------------------------");
        System.out.println("Size       Order              Average Time (Microseconds)");

        test(5, true);
        test(5, false);
        test(100, true);
        test(100, false);
    }
}
