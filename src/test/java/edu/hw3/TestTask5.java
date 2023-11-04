package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import edu.hw3.Task5.Person;
import edu.hw3.Task5.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask5 {

    static Stream<Arguments> ExamplesData() {
        ArrayList<Person> answer1 = new ArrayList<>(List.of(new Person("Thomas", "Aquinas"), new Person("Rene", "Descartes"), new Person("David", "Hume"), new Person("John", "Locke")));
        ArrayList<Person> answer2 = new ArrayList<>(List.of(new Person("Carl", "Gauss"), new Person("Leonhard", "Euler"), new Person("Paul", "Erdos")));

        return Stream.of(
            Arguments.of(new ArrayList<String>(List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes")), "ASC", answer1),
            Arguments.of(new ArrayList<String>(List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss")), "DESC", answer2),
            Arguments.of(null, "DESC", new ArrayList<Person>()),
            Arguments.of(new ArrayList<>(), "DESC", new ArrayList<Person>())
        );
    }

    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(ArrayList<String> contacts, String cmd, ArrayList<Person> expected) {
        // when
        ArrayList<Person> result = Main.parseContacts(contacts, cmd);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Неправильный формат сортировки")
    void IncorrectSortFormatTest() {
        // given
        ArrayList<String> contacts = new ArrayList<>();
        String cmd = "lol";

        // then
        assertThatThrownBy(() -> Main.parseContacts(contacts, cmd))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка чувствительности к регистру 1")
    void CheckSortCaseFormatTest1() {
        // given
        ArrayList<String> contacts = new ArrayList<String>(List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"));
        String cmd = "aSc";

        // when
        ArrayList<Person> result = Main.parseContacts(contacts, cmd);

        // then
        assertThat(result)
            .isEqualTo(new ArrayList<Person>(List.of(new Person("Thomas", "Aquinas"), new Person("Rene", "Descartes"), new Person("David", "Hume"), new Person("John", "Locke"))));
    }

    @Test
    @DisplayName("Проверка чувствительности к регистру 2")
    void CheckSortCaseFormatTest2() {
        // given
        ArrayList<String> contacts = new ArrayList<String>(List.of("John Locke", "Thomas aquInas", "David Hume", "Rene Descartes"));
        String cmd = "ASC";

        // then
        assertThatThrownBy(() -> Main.parseContacts(contacts, cmd))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> IncorrectContactExamples() {
        return Stream.of(
            Arguments.of(new ArrayList<String>(List.of("John Locke", "Thomas Aqu1nas", "David Hume", "Rene Descartes"))),
            Arguments.of(new ArrayList<String>(List.of("John Locke", "Thomas Aquinas Jovanovich", "David Hume", "Rene Descartes")))
        );
    }

    @ParameterizedTest
    @MethodSource("IncorrectContactExamples")
    @DisplayName("Некорректная контактная информация")
    void IncorrectContactTest(ArrayList<String> input) {
        // then
        assertThatThrownBy(() -> Main.parseContacts(input, "ASC"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Лист null")
    void NullListTest() {
        // then
        assertThat(Main.parseContacts(null, "ASC"))
            .isEqualTo(new ArrayList<Person>());
    }
}
