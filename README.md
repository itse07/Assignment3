# Sorting Algorithms Performance Analysis

## Project Overview

This project compares the execution time of four sorting algorithms implemented in Java:

1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Merge Sort

The purpose of this project is to analyze and compare the performance of these algorithms using different input sizes.

## Project Files

### Java Source Code

- **Bubble.java:** Implements Bubble Sort and measures its execution time.
- **Selection.java:** Implements Selection Sort and measures its execution time.
- **Insertion.java:** Implements Insertion Sort and measures its execution time.
- **Merge.java:** Implements Merge Sort and measures its execution time.

Each algorithm is tested independently.

### Excel File

**Sorting_Algorithms_Comparison.xlsx**

Contains the experimental results and a graph comparing the execution times of all four algorithms.

### Word and PDF Reports

**Sorting_Analysis_Report.docx**

Contains the project introduction, methodology, experimental results, and performance analysis.

**Sorting_Analysis_Report.pdf**

The final PDF version of the report.

## How to Run the Code

1. Install the Java Development Kit (JDK).
2. Open the project folder in Visual Studio Code.
3. Install the Extension Pack for Java if it is not already installed.
4. Open the Java file for the algorithm you want to test.
5. Click **Run** above the `main()` method.
6. View the execution time results in the terminal.

## Testing Methodology

The algorithms were tested using the following input sizes:

- 5 elements
- 10 elements
- 50 elements
- 100 elements

The input arrays were generated in descending order.

For each input size:

- The algorithm was executed 10,000 times per measurement run.
- Five measurement runs were performed.
- `System.nanoTime()` was used to measure execution time.
- The average execution time per sorting operation was calculated in microseconds.

## Time Complexity

| Algorithm | Best Case | Average Case | Worst Case |
|---|---|---|---|
| Bubble Sort | O(N²) | O(N²) |