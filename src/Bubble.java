
public class Bubble {

    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        // Repeat the sorting process
        for (int i = 0; i < n - 1; i++) {

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {

                // Swap elements if they are in the wrong order
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
            bubbleSort(warmup);
        }

        // Perform multiple measurement runs
        for (int r = 0; r < runs; r++) {

            int[][] testArrays = new int[repetitions][];

            // Prepare arrays before starting the timer
            for (int i = 0; i < repetitions; i++) {
                testArrays[i] = originalArray.clone();
            }

            long startTime = System.nanoTime();

            // Execute Bubble Sort on all test arrays
            for (int i = 0; i < repetitions; i++) {
                bubbleSort(testArrays[i]);
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

        System.out.println("Bubble Sort Performance Analysis");
        System.out.println("--------------------------------");

        System.out.printf("%-15s %-25s%n", "Input Size", "Average Time (Microseconds)");

        // Test Bubble Sort with different input sizes
        for (int size : sizes) {

            int[] arr = generateWorstCaseArray(size);

            double averageTime = measureTime(arr);

            System.out.printf("%-15d %-25.6f%n", size, averageTime);
        }
    }
}
