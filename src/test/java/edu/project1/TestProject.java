package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProject {

    @ParameterizedTest
    @DisplayName("Некорректное число максимальных попыток")
    @ValueSource(ints = {-1, 0, 11, 12})
    void maxAttemptsTests(int maxAttempts) {
        // then
        assertThatThrownBy(() -> new Session(maxAttempts))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка на возможность сдаться")
    void giveUpTest() throws IOException {

        // GIVEN

        // file (relative path?) with the input
        String fileInputPath = new File("").getAbsolutePath() + "/src/test/java/edu/project1/giveUpInput.txt";
        String fileOutputPath = new File("").getAbsolutePath() + "/src/test/java/edu/project1/giveUpOutput.txt";

        // Create FileInputStream to read the file
        try (FileInputStream fileInputStream = new FileInputStream(fileInputPath);
             PrintStream fileOutputStream = new PrintStream(fileOutputPath)) {
            // Redirect System.in to fileInputStream
            System.setIn(fileInputStream);

            // Redirect System.out to fileOutputStream
            System.setOut(fileOutputStream);

            // Start new game session
            Session session = new Session(5);

            session.startSession();

        }

        // WHEN

        try {
            // Use Path for creating object Path using the path to the file
            Path path = Paths.get(fileOutputPath);

            // Use Files.readString() in order to read all the data from the file
            String fileContent = Files.readString(path);

            // THEN

            assertTrue(fileContent.equals("Guess a letter:\r\nYou lost!\r\n") ||
                fileContent.equals("Guess a letter:\nYou lost!\n"));

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Test
    @DisplayName("Проверка на обработку некорректных данных")
    void incorrectDataTest() throws IOException {

        // GIVEN

        // file (relative path?) with the input
        String fileInputPath = new File("").getAbsolutePath() + "/src/test/java/edu/project1/incorrectDataInput.txt";
        String fileOutputPath = new File("").getAbsolutePath() + "/src/test/java/edu/project1/incorrectDataOutput.txt";

        // Create FileInputStream to read the file
        try (FileInputStream fileInputStream = new FileInputStream(fileInputPath);
             PrintStream fileOutputStream = new PrintStream(fileOutputPath)) {
            // Redirect System.in to fileInputStream
            System.setIn(fileInputStream);

            // Redirect System.out to fileOutputStream
            System.setOut(fileOutputStream);

            // Start new game session
            Session session = new Session(5);

            session.startSession();

        }

        // WHEN

        try {
            // Use Path for creating object Path using the path to the file
            Path path = Paths.get(fileOutputPath);

            // Use Files.readString() in order to read all the data from the file
            String fileContent = Files.readString(path);

            // THEN

            assertTrue(fileContent.equals("Guess a letter:\r\nIncorrect input. Try again\n\r\n".repeat(6) +
                "Guess a letter:\r\nYou lost!\r\n") ||
                fileContent.equals("Guess a letter:\nIncorrect input. Try again\n\n".repeat(6) +
                    "Guess a letter:\nYou lost!\n"));

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Test
    @DisplayName("Проверка на повторяющиеся буквы")
    void repeatedLettersTest() throws IOException {

        // GIVEN

        // file (relative path?) with the input
        String fileInputPath = new File("").getAbsolutePath() + "/src/test/java/edu/project1/repeatedLettersInput.txt";
        String fileOutputPath =
            new File("").getAbsolutePath() + "/src/test/java/edu/project1/repeatedLettersOutput.txt";

        // Create FileInputStream to read the file
        try (FileInputStream fileInputStream = new FileInputStream(fileInputPath);
             PrintStream fileOutputStream = new PrintStream(fileOutputPath)) {
            // Redirect System.in to fileInputStream
            System.setIn(fileInputStream);

            // Redirect System.out to fileOutputStream
            System.setOut(fileOutputStream);

            // Start new game session
            Session session = new Session(5);

            session.startSession();

        }

        // WHEN

        try {
            // Use Path for creating object Path using the path to the file
            Path path = Paths.get(fileOutputPath);

            // Use Files.readString() in order to read all the data from the file
            String fileContent = Files.readString(path);

            boolean result = fileContent.contains("You have already used this letter. Try another one.");

            // THEN

            assertThat(result)
                .isEqualTo(true);

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
