package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask3 {

    static Stream<Arguments> ExamplesData() {

        var animal1 = new Animal("Einstein", Animal.Type.FISH, Animal.Sex.M, 7, 5, 0.28, true);
        var animal2 = new Animal("Rainbow Fish", Animal.Type.FISH, Animal.Sex.M, 8, 2, 0.45, false);
        var animal3 = new Animal("Chirpy", Animal.Type.BIRD, Animal.Sex.M, 7, 16, 0.23, true);
        var animal4 = new Animal("Indy", Animal.Type.BIRD, Animal.Sex.F, 11, 13, 0.90, true);
        var animal5 = new Animal("Fifi", Animal.Type.DOG, Animal.Sex.F, 12, 96, 61.00, true);
        var animal6 = new Animal("Moana", Animal.Type.FISH, Animal.Sex.F, 9, 9, 0.45, true);
        var animal7 = new Animal("Kai", Animal.Type.SPIDER, Animal.Sex.M, 25, 4, 0.14, false);
        var animal8 = new Animal("Oliver", Animal.Type.CAT, Animal.Sex.M, 11, 24, 6.00, false);
        var animal9 = new Animal("Otis", Animal.Type.CAT, Animal.Sex.M, 8, 24, 5.00, true);
        var animal10 = new Animal("Baby", Animal.Type.BIRD, Animal.Sex.M, 9, 13, 0.62, true);

        var animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals, Map.of(Animal.Type.CAT, 2, Animal.Type.BIRD, 3, Animal.Type.DOG, 1, Animal.Type.FISH, 3, Animal.Type.SPIDER, 1))
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(List<Animal> animals, Map<Animal.Type, Integer> expected) {
        // when
        var result = Task3.countTypeDict(animals);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
