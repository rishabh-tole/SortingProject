import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort {

    // QuickSort algorithm implementation
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);  // Recursively sort elements before partition
            quickSort(arr, pi + 1, high); // Recursively sort elements after partition
        }
    }

    // Partition function to place the pivot in the correct position
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap function to swap two elements
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

            // Sorting the data
            quickSort(data, 0, data.length - 1);

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
