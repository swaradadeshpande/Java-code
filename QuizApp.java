
import java.io.File;
import java.util.Scanner;

class InvalidAnswerException extends Exception {
    public InvalidAnswerException(String message) {
        super(message);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        int score = 0;
        Scanner console = new Scanner(System.in);

        // Outer Try: Handles the file reading
        try (Scanner fileScanner = new Scanner(new File("questions.txt"))) {
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(","); // format: Question,Opt1,Opt2,Opt3,CorrectIndex
                
                System.out.println("\n" + data[0]);
                System.out.println("1) " + data[1]);
                System.out.println("2) " + data[2]);
                System.out.println("3) " + data[3]);

                // Nested Try: Handles the user interaction for each question
                try {
                    System.out.print("Enter your answer (1-3): ");
                    int userAnswer = Integer.parseInt(console.nextLine());

                    // Custom Exception usage
                    if (userAnswer < 1 || userAnswer > 3) {
                        throw new InvalidAnswerException("Invalid choice! Pick 1, 2, or 3.");
                    }

                    int correct = Integer.parseInt(data[4]);
                    if (userAnswer == correct) {
                        System.out.println("Correct!");
                        score++;
                    } else {
                        System.out.println("Wrong! The correct answer was " + correct);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Input error! Please enter a number.");
                } catch (InvalidAnswerException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("\n--- Quiz Finished ---");
            System.out.println("Your Final Score: " + score);

        } catch (Exception e) {
            System.out.println("File error: " + e.getMessage());
        } finally {
            console.close();
        }
    }
}
