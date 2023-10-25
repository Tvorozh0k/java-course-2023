package edu.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Session {

    // Positions of the letters from answer:
    // For example:
    // Answer = "hello"
    // letterPositions['h'] = { 0 }
    // letterPositions['e'] = { 1 }
    // letterPositions['l'] = { 2, 3 }
    // letterPositions['o'] = { 4 }
    private final HashMap<Character, ArrayList<Integer>> letterPositions;

    // The maximum amount of attempts to guess the answer
    private final int maxAttempts;

    // What to show as an answer in the process of playing
    private final char[] displayedAnswer;

    // Current amount of user's attempts
    private int attempts;

    // Current amount of user's guesses
    private int guessed;

    // Chosen by user letters
    private final HashSet<Character> usedLetters;

    // Scanner for getting user's input
    private final Scanner in = new Scanner(System.in);

    public Session(int maxAttempts) throws IllegalArgumentException {
        // The correct answer of the game
        // Words generator
        BagOfWords words = new BagOfWords();
        String correctAnswer = words.getWord();

        this.letterPositions = new HashMap<>();

        // Getting letters positions
        for (int i = 0; i < correctAnswer.length(); ++i) {
            Character sym = correctAnswer.charAt(i);

            if (!letterPositions.containsKey(sym)) {
                letterPositions.put(sym, new ArrayList<>());
            }

            letterPositions.get(sym).add(i);
        }

        this.displayedAnswer = "*".repeat(correctAnswer.length()).toCharArray();
        this.attempts = 0;
        this.guessed = 0;
        this.usedLetters = new HashSet<>();

        // The maximum amount of attempts bust be more than zero
        if (0 < maxAttempts && maxAttempts <= 10) {
            this.maxAttempts = maxAttempts;
        } else {
            throw new IllegalArgumentException("Ошибка: число попыток должно быть от 1 до 10");
        }
    }

    public void startSession() {
        // if attempts == maxAttempts and guessed < letterPositions.size(), user lost
        // if attempts < maxAttempts and guessed == letterPositions.size(), user won
        while (attempts < maxAttempts && guessed < letterPositions.size()) {

            // Getting the letter from user
            System.out.println("Guess a letter:");
            String input = in.nextLine();

            // Is it a letter or an attempt to give up?
            if (input.equalsIgnoreCase("give up")) {
                attempts = maxAttempts;
                break;
            }

            // It has to be a letter
            if (input.length() != 1) {
                System.out.println("Incorrect input. Try again\n");
                continue;
            }

            // Getting the letter
            Character sym = Character.toLowerCase(input.charAt(0));

            // The character must be the letter from English language
            if (!('a' <= sym && sym <= 'z')) {
                System.out.println("Incorrect input. Try again\n");
                continue;
            }

            // Has user already used this letter before?
            if (usedLetters.contains(sym)) {
                System.out.print("You have already used this letter. Try another one.\n\n");
                continue;
            }

            // Check, if the letter is in answer or not
            if (letterPositions.containsKey(sym)) {
                System.out.print("Hit!\n\n");

                for (Integer pos : letterPositions.get(sym)) {
                    displayedAnswer[pos] = sym;
                }

                System.out.printf("The word: %s\n\n", new String(displayedAnswer));

                ++guessed;
            } else {
                System.out.printf("Missed, mistake %d out of %d.\n\n", ++attempts, maxAttempts);
                System.out.printf("The word: %s\n\n", new String(displayedAnswer));
            }

            usedLetters.add(sym);
        }

        // Does user win or not?
        if (attempts < maxAttempts) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!");
        }
    }
}
