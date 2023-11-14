package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask15 {

    static Stream<Arguments> ExamplesData() {

        var animal1 = new Animal("Caspian", Animal.Type.FISH, Animal.Sex.F, 6, 9, 0.38, false);
        var animal2 = new Animal("Rin Fin Fin", Animal.Type.FISH, Animal.Sex.F, 5, 2, 0.56, false);
        var animal3 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 8, 47, 34.00, true);
        var animal4 = new Animal("Lucy", Animal.Type.BIRD, Animal.Sex.F, 7, 12, 0.83, true);
        var animal5 = new Animal("Bailey", Animal.Type.BIRD, Animal.Sex.F, 14, 14, 0.41, false);
        var animal6 = new Animal("Midnight", Animal.Type.SPIDER, Animal.Sex.M, 25, 7, 0.08, true);
        var animal7 = new Animal("Gigi", Animal.Type.CAT, Animal.Sex.F, 11, 25, 7.00, true);
        var animal8 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 5, 34, 71.00, true);
        var animal9 = new Animal("Queen", Animal.Type.CAT, Animal.Sex.F, 12, 24, 7.00, false);
        var animal10 = new Animal("Rainbow Fish", Animal.Type.FISH, Animal.Sex.F, 4, 4, 0.52, true);

        var animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals, Map.of(Animal.Type.DOG, 105.0, Animal.Type.BIRD, 0.83, Animal.Type.FISH, 0.9400000000000001))
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(List<Animal> animals, Map<Animal.Type, Integer> expected) {
        // when
        var result = Task15.sumWeightsByType(animals, 5, 10);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> ErrorTestData() {

        var animal1 = new Animal("Caspian", Animal.Type.FISH, Animal.Sex.F, 6, 9, 0.38, false);
        var animal2 = new Animal("Rin Fin Fin", Animal.Type.FISH, Animal.Sex.F, 5, 2, 0.56, false);
        var animal3 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 8, 47, 34.00, true);
        var animal4 = new Animal("Lucy", Animal.Type.BIRD, Animal.Sex.F, 7, 12, 0.83, true);
        var animal5 = new Animal("Bailey", Animal.Type.BIRD, Animal.Sex.F, 14, 14, 0.41, false);
        var animal6 = new Animal("Midnight", Animal.Type.SPIDER, Animal.Sex.M, 25, 7, 0.08, true);
        var animal7 = new Animal("Gigi", Animal.Type.CAT, Animal.Sex.F, 11, 25, 7.00, true);
        var animal8 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 5, 34, 71.00, true);
        var animal9 = new Animal("Queen", Animal.Type.CAT, Animal.Sex.F, 12, 24, 7.00, false);
        var animal10 = new Animal("Rainbow Fish", Animal.Type.FISH, Animal.Sex.F, 4, 4, 0.52, true);

        var animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals, -1, 10),
            Arguments.of(animals, 0, 10),
            Arguments.of(animals, 1, -1),
            Arguments.of(animals, 1, 0),
            Arguments.of(animals, 5, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("ErrorTestData")
    @DisplayName("Некорректные входные данные")
    void IncorrectInputTests(List<Animal> animals, int k, int l) {
        // then
        assertThatThrownBy(() -> Task15.sumWeightsByType(animals, k, l))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
