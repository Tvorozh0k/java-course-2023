package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask10 {

    static Stream<Arguments> ExamplesData() {

        var animal1 = new Animal("Baby", Animal.Type.BIRD, Animal.Sex.M, 2, 16, 0.32, true);
        var animal2 = new Animal("Rin Fin Fin", Animal.Type.FISH, Animal.Sex.F, 5, 4, 0.38, false);
        var animal3 = new Animal("Ellie", Animal.Type.DOG, Animal.Sex.F, 4, 17, 30.00, false);
        var animal4 = new Animal("Arthur", Animal.Type.BIRD, Animal.Sex.M, 7, 19, 0.74, true);
        var animal5 = new Animal("Lacey", Animal.Type.CAT, Animal.Sex.F, 4, 24, 4.00, true);
        var animal6 = new Animal("Foxy", Animal.Type.DOG, Animal.Sex.F, 10, 81, 83.00, true);
        var animal7 = new Animal("Ziggy", Animal.Type.SPIDER, Animal.Sex.M, 8, 4, 0.07, true);
        var animal8 = new Animal("Itsy", Animal.Type.SPIDER, Animal.Sex.M, 16, 11, 0.13, false);
        var animal9 = new Animal("Otis", Animal.Type.CAT, Animal.Sex.M, 17, 24, 5.00, true);
        var animal10 = new Animal("Moana", Animal.Type.FISH, Animal.Sex.F, 9, 9, 0.45, true);

        var animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals, List.of(animal2, animal4, animal6, animal8, animal9, animal10))
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(List<Animal> animals, List<Animal> expected) {
        // when

        var result = Task10.ageIsNotEqualPaws(animals);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
