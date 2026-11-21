
public class Selection {

    // Selection Sort Algorithm
    public static void selectionSort(int[] arr) {

        int n = arr.length;

        // Traverse the array
        for (int i = 0; i < n - 1; i++) {

            // Assume the current element is the minimum
            int minIndex = i;

            // Find the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the current element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Generate a descending array for worst-case testing
    public static int[] generateWorstCaseArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

        return arr;
    }

    // Measure the average execution time
    public static double measureTime(int[] originalArray) {

        int repetitions = 10000;
        int runs = 5;

        long totalTime = 0;

        // Warm up the Java Virtual Machine
        for (int i = 0; i < 2000; i++) {
            int[] warmup = originalArray.clone();
            selectionSort(warmup);
        }

        // Perform multiple measurement runs
        for (int r = 0; r < runs; r++) {

            int[][] testArrays = new int[repetitions][];

            // Prepare arrays before starting the timer
            for (int i = 0; i < repetitions; i++) {
                testArrays[i] = originalArray.clone();
            }

            long startTime = System.nanoTime();

            // Execute Selection Sort on all test arrays
            for (int i = 0; i < repetitions; i++) {
                selectionSort(testArrays[i]);
            }

            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);

            // Verify that the sorting result is correct
            if (testArrays[repetitions - 1][0] != 1) {
                System.out.println("Sorting Error!");
            }
        }

        // Calculate average execution time in microseconds
        double averageTime = (double) totalTime / (runs * repetitions);

        return averageTime / 1000.0;
    }

    public static void main(String[] args) {

        // Define the required input sizes
        int[] sizes = {5, 10, 50, 100};

        System.out.println("Selection Sort Performance Analysis");
        System.out.println("-----------------------------------");

        System.out.printf("%-15s %-25s%n",
                "Input Size", "Average Time (Microseconds)");

        // Test Selection Sort with different input sizes
        for (int size : sizes) {

            int[] arr = generateWorstCaseArray(size);

            double averageTime = measureTime(arr);

            System.out.printf("%-15d %-25.6f%n", size, averageTime);
        }
    }
}
