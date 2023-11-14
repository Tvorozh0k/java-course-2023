package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask4 {

    static Stream<Arguments> ExamplesData() {

        var animal3 = new Animal("Chirpy", Animal.Type.BIRD, Animal.Sex.M, 7, 16, 0.23, true);
        var animal4 = new Animal("Indy", Animal.Type.BIRD, Animal.Sex.F, 11, 13, 0.90, true);
        var animal5 = new Animal("Fifi", Animal.Type.DOG, Animal.Sex.F, 12, 96, 61.00, true);
        var animal6 = new Animal("Moana", Animal.Type.FISH, Animal.Sex.F, 9, 9, 0.45, true);
        var animal7 = new Animal("Kai", Animal.Type.SPIDER, Animal.Sex.M, 25, 4, 0.14, false);
        var animal8 = new Animal("Oliver", Animal.Type.CAT, Animal.Sex.M, 11, 24, 6.00, false);
        var animal9 = new Animal("Otis", Animal.Type.CAT, Animal.Sex.M, 8, 24, 5.00, true);
        var animal10 = new Animal("Baby", Animal.Type.BIRD, Animal.Sex.M, 9, 13, 0.62, true);

        var animals = List.of(animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals)
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(List<Animal> animals) {
        // when
        var result = Task4.longestNameAnimal(animals);

        // then
        assertThat(animals.contains(result))
            .isTrue();

        assertThat(result.name().length())
            .isEqualTo(animals.stream().mapToInt(a -> a.name().length()).max().orElseThrow());
    }

    @Test
    @DisplayName("Пустой список")
    void EmptyListTest() {
        // then
        assertThatThrownBy(() -> Task4.longestNameAnimal(new ArrayList<>()))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
