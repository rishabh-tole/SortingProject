import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoSort {

    // BingoSort algorithm implementation
    private void bingoSort(int[] arr) {
        int n = arr.length;

        // Find the smallest element in the array
        int smallest = findMin(arr);
        int largestSortedIndex = -1;

        while (largestSortedIndex < n - 1) {
            // Identify the current smallest unsorted element
            int nextSmallest = Integer.MAX_VALUE;

            // Scan through the unsorted portion of the array
            for (int i = largestSortedIndex + 1; i < n; i++) {
                if (arr[i] == smallest) {
                    largestSortedIndex++;
                    swap(arr, i, largestSortedIndex);
                } else if (arr[i] < nextSmallest) {
                    nextSmallest = arr[i];
                }
            }

            // Move to the next smallest element for the next pass
            smallest = nextSmallest;
        }
    }

    // Helper function to find the minimum element in the array
    private int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to sort a dataset from a file and return the time taken
    public long sortFile(String filename) {
        try {
            // Reading data from the file
            int[] data = readFile(filename);

            // Start timing
            long startTime = System.nanoTime();

            // Sorting the data using Bingo Sort
            bingoSort(data);

            // End timing
            long endTime = System.nanoTime();

            return endTime - startTime;
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return -1;
        }
    }

    // Function to read integers from a file using Scanner
    private int[] readFile(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        List<Integer> dataList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            dataList.add(scanner.nextInt());
        }
        scanner.close();
        return dataList.stream().mapToInt(i -> i).toArray();
    }
}
