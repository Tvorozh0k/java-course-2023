package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask16 {

    static Stream<Arguments> ExamplesData() {

        var animal1 = new Animal("Bailey", Animal.Type.BIRD, Animal.Sex.F, 15, 20, 0.64, true);
        var animal2 = new Animal("Mila", Animal.Type.CAT, Animal.Sex.F, 5, 24, 5.00, true);
        var animal3 = new Animal("Rin Fin Fin", Animal.Type.FISH, Animal.Sex.F, 3, 3, 0.31, false);
        var animal4 = new Animal("Oliver", Animal.Type.CAT, Animal.Sex.M, 16, 24, 7.00, true);
        var animal6 = new Animal("Jupiter", Animal.Type.FISH, Animal.Sex.M, 9, 5, 0.47, true);
        var animal7 = new Animal("Rudy", Animal.Type.DOG, Animal.Sex.M, 10, 63, 27.00, true);
        var animal8 = new Animal("Genevieve", Animal.Type.DOG, Animal.Sex.F, 9, 43, 43.00, true);
        var animal9 = new Animal("Peep", Animal.Type.BIRD, Animal.Sex.M, 5, 11, 0.61, false);
        var animal10 = new Animal("Hootie", Animal.Type.BIRD, Animal.Sex.F, 4, 14, 0.52, false);

        var animals = List.of(animal1, animal2, animal3, animal4, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals, List.of(animal4, animal2, animal7, animal8, animal9, animal1, animal10, animal6, animal3))
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(List<Animal> animals, List<Animal> expected) {
        // when
        var result = Task16.sortByTypeSexName(animals);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
