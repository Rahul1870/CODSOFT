    // TASK 2
    // WORD COUNTER
    //CODSOFT


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Word Counter!");

        // Prompt the user for input source (text or file)
        System.out.print("Enter 'T' to input text, 'F' to input a file: ");
        String inputSource = scanner.nextLine();

        if (inputSource.equalsIgnoreCase("T")) {
            // Input is from the user
            System.out.print("Enter your text: ");
            String inputText = scanner.nextLine();
            int wordCount = countWords(inputText);
            System.out.println("Total words: " + wordCount);
        } else if (inputSource.equalsIgnoreCase("F")) {
            // Input is from a file
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                String fileContent = readFile(filePath);
                int wordCount = countWords(fileContent);
                System.out.println("Total words: " + wordCount);
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.err.println("Invalid input source. Please enter 'T' or 'F'.");
        }

        scanner.close();
    }

    // Function to count words in a string
    public static int countWords(String text) {
        String[] words = text.split("\\s+"); // Split by spaces
        return words.length;
    }

    // Function to read a file and return its content as a string
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
