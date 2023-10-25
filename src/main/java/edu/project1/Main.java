package edu.project1;

public final class Main {

    /*

    Guess a letter:
    a
    Missed, mistake 1 out of 5.

    The word: ********

    Guess a letter:
    b
    Missed, mistake 2 out of 5.

    The word: ********

    Guess a letter:
    c
    Missed, mistake 3 out of 5.

    The word: ********

    Guess a letter:
    d
    Hit!

    The word: *****d**

    Guess a letter:
    d
    You have already guessed this letter. Try another one.

    Guess a letter:
    e
    Hit!

    The word: ***e*de*

    Guess a letter:
    r
    Hit!

    The word: ***e*der

    Guess a letter:
    f
    Hit!

    The word: *ffe*der

    Guess a letter:
    o
    Hit!

    The word: offe*der

    Guess a letter:
    n
    Hit!

    The word: offender

    You won!

     */

    public static void main(String[] args) {
        Session session = new Session(5);
        session.startSession();
    }
}
