import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        QuickSort qs = new QuickSort();
        BingoSort ms = new BingoSort();

        List<Integer> sizes = new ArrayList<>();
        List<Long> quickSortTimes = new ArrayList<>();
        List<Long> stoogeSortTimes = new ArrayList<>();

        // Loop through different sizes of input
        for (int N = 1000; N <= 250000; N += 1000) {
            String fileName = "Data.txt";

            // Generate data of size N
            //generator.GenerateMergeSortWorstCaseData(3, N, fileName);
            generator.GenerateBingoSortOptimalData(5, N, 1000,fileName);

            // Measure QuickSort time
            long quickTime = qs.sortFile(fileName);
            quickSortTimes.add(quickTime / 1000000);  // Convert nanoseconds to milliseconds

            // Measure MergeSort time
            long stoogeTime = ms.sortFile(fileName);
            stoogeSortTimes.add(stoogeTime / 1000000);  // Convert nanoseconds to milliseconds

            System.out.println(N + ": " + quickTime/ 1000000 + " " + stoogeTime/ 1000000);

            sizes.add(N);  // Store the size of data
        }

        // Write the data to a CSV file
        writeCSV("sort_times.csv", sizes, quickSortTimes, stoogeSortTimes);
    }

    // Function to write data to a CSV file
    private static void writeCSV(String filename, List<Integer> sizes, List<Long> quickSortTimes, List<Long> mergeSortTimes) {
        try (FileWriter writer = new FileWriter(filename)) {
            // Write CSV headers
            writer.write("Size,QuickSortTime(ms), BingoSortTime(ms)\n");

            // Write each data point
            for (int i = 0; i < sizes.size(); i++) {
                writer.write(sizes.get(i) + "," + quickSortTimes.get(i) + "," + mergeSortTimes.get(i) + "\n");
            }

            System.out.println("CSV file generated successfully: " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the CSV file: " + e.getMessage());
        }
    }
}
