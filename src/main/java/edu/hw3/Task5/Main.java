package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Parsing contacts
     * @param contacts The list of contact info
     * @param cmd The way how to sort the list ("ASC" or "DESC")
     * @return Sorted list with contact info
     */
    public static ArrayList<Person> parseContacts(ArrayList<String> contacts, String cmd) throws IllegalArgumentException {
        if (!cmd.equalsIgnoreCase("ASC") && !cmd.equalsIgnoreCase("DESC")) {
            throw new IllegalArgumentException("Ошибка: вид сортировки cmd принимает значения ASC (возр.) или DESC (убыв.)");
        }

        ArrayList<Person> result = new ArrayList<>();

        if (contacts == null) {
            return result;
        }

        // Parsing

        for (String str : contacts) {
            String[] info = str.split(" ");

            if (info.length > 2) {
                throw new IllegalArgumentException("Ошибка: контактная информация - строка из не более 2 слов");
            }

            String firstName = info[0];

            if (!firstName.matches("[A-Z][a-z]+")) {
                throw new IllegalArgumentException("Ошибка: некорректная контактная информация");
            }

            String lastName = (info.length == 2) ? info[1] : null;

            if (lastName != null && !lastName.matches("[A-Z][a-z]+")) {
                throw new IllegalArgumentException("Ошибка: некорректная контактная информация");
            }

            result.add(new Person(firstName, lastName));
        }

        // Sorting

        int order = (cmd.equalsIgnoreCase("ASC")) ? 1 : -1;

        result.sort((a, b) -> order * new PersonComparator().compare(a, b));

        return result;
    }

    public static void main(String[] args) {
        // parseContacts([ "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes" ], "ASC")  ->
        // [ "Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke" ]
        LOGGER.info(parseContacts(new ArrayList<String>(List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes")), "ASC"));

        // parseContacts(["Paul Erdos", "Leonhard Euler", "Carl Gauss"], "DESC") ->
        // ["Carl Gauss", "Leonhard Euler", "Paul Erdos"]
        LOGGER.info(parseContacts(new ArrayList<String>(List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss")), "DESC"));

        // parseContacts(null, "DESC") ➞ []
        LOGGER.info(parseContacts(null, "DESC"));

        // parseContacts([], "DESC") ➞ []
        LOGGER.info(parseContacts(new ArrayList<>(), "DESC"));
    }
}
