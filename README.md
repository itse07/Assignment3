# Empirical Analysis of Sorting Algorithms

## Course: Analysis of Algorithms

### Assignment 2

## Project Description

This project implements and compares four sorting algorithms using Java. The objective is to analyze their execution time, auxiliary space complexity, and performance under different input sizes and input orders.

All four sorting algorithms were implemented from scratch without using Java's built-in sorting methods.

## Algorithms Implemented

1. **Selection Sort**
2. **Bubble Sort (Optimized)**
3. **Quick Sort**
4. **Merge Sort**

## Project Files

| File | Description |
|---|---|
| `SelectionSort.java` | Selection Sort implementation and performance testing |
| `BubbleSort.java` | Optimized Bubble Sort implementation and performance testing |
| `QuickSort.java` | Quick Sort implementation using the last element as pivot |
| `MergeSort.java` | Merge Sort implementation using divide and conquer |
| `README.md` | Project documentation and execution instructions |

## Testing Methodology

Each sorting algorithm was tested using four different cases:

| Array Size | Input Order |
|---|---|
| 5 | Sorted |
| 5 | Reverse Sorted |
| 100 | Sorted |
| 100 | Reverse Sorted |

A total of **16 test cases** were evaluated.

Execution time was measured using Java's `System.nanoTime()` method.

For each test case:

- Three measurement runs were performed.
- Each measurement included 10,000 sorting repetitions.
- A JVM warm-up measurement was performed before collecting results.
- The original array was copied before each sorting repetition.
- The average execution time was calculated in microseconds (µs).

**Note:** The measured times include array copying overhead.

## How to Run the Project

### Requirements

- Java Development Kit (JDK)
- Visual Studio Code or any Java-compatible IDE

### Step 1: Clone the Repository

```bash
git clone <repository-url>
```

Replace `<repository-url>` with the actual GitHub repository URL.

### Step 2: Open the Project

Open the downloaded project folder in Visual Studio Code.

### Step 3: Compile and Run

Open the terminal inside the project folder and execute the following commands.

**Selection Sort**

```bash
javac SelectionSort.java
java SelectionSort
```

**Bubble Sort**

```bash
javac BubbleSort.java
java BubbleSort
```

**Quick Sort**

```bash
javac QuickSort.java
java QuickSort
```

**Merge Sort**

```bash
javac MergeSort.java
java MergeSort
```

Each program automatically executes the four required test cases and displays the average execution time.

## Experimental Results

All execution times are measured in microseconds (µs).

| Algorithm | Size | Sorted | Reverse Sorted |
|---        |---    |---    |---            |
| Selection Sort| 5 | 0.075200 | 0.041323 |
| Selection Sort | 100 | 1.582177 | 2.279443 |
| Bubble Sort | 5 | 0.065463 | 0.055137 |
| Bubble Sort | 100 | 0.032673 | 4.626067 |
| Quick Sort | 5 | 0.100413 | 0.079180 |
| Quick Sort | 100 | 2.743487 | 2.338743 |
| Merge Sort | 5 | 0.168210 | 0.149047 |
| Merge Sort | 100 | 1.714380 | 2.060537 |

These results were obtained experimentally and may vary depending on the machine, JVM optimizations, and system conditions.

## Time and Space Complexity

| Algorithm | Best Case | Average Case | Worst Case | Auxiliary Space |
|---        |---        |---            |---        |---                |
| Selection Sort | O(n²) | O(n²)        | O(n²)     | O(1)              |
| Bubble Sort    | O(n)  | O(n²)        |      O(n²)| O(1)              |
| Quick Sort  | O(n log n) | O(n log n) | O(n²)     | O(log n) average, O(n) worst |
| Merge Sort | O(n log n) | O(n log n)  | O(n log n) | O(n) |

## Conclusion

The experiment demonstrates how input size and initial input order affect sorting performance.

Optimized Bubble Sort performs well on already sorted arrays, while Selection Sort provides simple and predictable behavior.

Quick Sort is generally efficient but can experience worst-case performance when the last element is selected as the pivot for sorted or reverse-sorted arrays.

Merge Sort provides consistent O(n log n) time complexity, making it a suitable choice for larger datasets when additional memory is available.

## Author

**Abdel Rahman**

Software Engineering Student

Analysis of Algorithms — Assignment 2