import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {

    public void GenerateData(int numDigits, int numNumbers, String fileName) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < numNumbers; i++) {
                int min = (int) Math.pow(10, numDigits - 1);
                int max = (int) Math.pow(10, numDigits) - 1;
                int randomNumber = random.nextInt(max - min + 1) + min;

                writer.write(randomNumber + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Generates data that is least optimal for Merge Sort (already sorted data)
    public void GenerateMergeSortWorstCaseData(int numDigits, int numNumbers, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            int min = (int) Math.pow(10, numDigits - 1);
            for (int i = 0; i < numNumbers; i++) {
                writer.write((min + i) + "\n"); // Writing data in sorted order
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Generates data that is least optimal for Quick Sort (reverse sorted data)
    public void GenerateQuickSortWorstCaseData(int numDigits, int numNumbers, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            int min = (int) Math.pow(10, numDigits - 1);
            for (int i = 0; i < numNumbers; i++) {
                writer.write((min + numNumbers - i - 1) + "\n"); // Writing data in reverse sorted order
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // Generates data with a user-defined range, optimal for Bingo Sort
    public void GenerateBingoSortOptimalData(int numDigits, int numNumbers, int range, String fileName) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(fileName)) {
            int min = (int) Math.pow(10, numDigits - 1);
            int max = min + range - 1; // Adjust max based on the provided range

            for (int i = 0; i < numNumbers; i++) {
                int randomNumber = random.nextInt(max - min + 1) + min;
                writer.write(randomNumber + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
