
public class Merge {

    // Merge two sorted parts of the array
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Merge Sort algorithm
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Generate an array in descending order
    public static int[] generateWorstCaseArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

        return arr;
    }

    // Measure average execution time
    public static double measureTime(int[] originalArray) {
        int repetitions = 10000;
        int runs = 5;
        long totalTime = 0;

        // JVM warm-up
        for (int i = 0; i < 2000; i++) {
            int[] warmup = originalArray.clone();
            mergeSort(warmup, 0, warmup.length - 1);
        }

        for (int r = 0; r < runs; r++) {

            // Prepare arrays before starting the timer
            int[][] testArrays = new int[repetitions][];

            for (int i = 0; i < repetitions; i++) {
                testArrays[i] = originalArray.clone();
            }

            long startTime = System.nanoTime();

            for (int i = 0; i < repetitions; i++) {
                mergeSort(testArrays[i], 0, testArrays[i].length - 1);
            }

            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);

            // Check sorting correctness
            for (int i = 1; i < testArrays[repetitions - 1].length; i++) {
                if (testArrays[repetitions - 1][i - 1] >
                    testArrays[repetitions - 1][i]) {
                    System.out.println("Sorting Error!");
                    break;
                }
            }
        }

        double averageTime = (double) totalTime / (runs * repetitions);

        return averageTime / 1000.0;
    }

    public static void main(String[] args) {
        int[] sizes = {5, 10, 50, 100};

        System.out.println("Merge Sort Performance Analysis");
        System.out.println("--------------------------------");

        System.out.printf("%-15s %-25s%n",
                "Input Size", "Average Time (Microseconds)");

        for (int size : sizes) {
            int[] arr = generateWorstCaseArray(size);
            double averageTime = measureTime(arr);

            System.out.printf("%-15d %-25.6f%n",
                    size, averageTime);
        }
    }
}
