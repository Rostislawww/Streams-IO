import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.print("Enter a single character: ");
            userInput = myObj.nextLine();
            if (userInput.length() == 1) {
                break;
            } else {
                System.out.println("Error: Please enter exactly one character.");
            }
        }
        System.out.println("The character entered is - " + userInput);
        String filePath = "C:\\Users\\Rostikslaw\\Desktop\\xanadu.txt";
        try {
            String content = readFile(filePath);
            int count = 0;
            for (int i = 0; i < content.length(); i++) {
                if (content.charAt(i) == userInput.charAt(0)) {
                    count++;
                }
            }
            System.out.println("The character '" + userInput + "' appears " + count + " times.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            myObj.close();
        }
    }
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
