package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask17 {

    static Stream<Arguments> ExamplesData() {

        var animal1 = new Animal("Arya", Animal.Type.DOG, Animal.Sex.F, 4, 81, 83.00, true);
        var animal2 = new Animal("Carmel", Animal.Type.SPIDER, Animal.Sex.F, 12, 9, 0.06, true);
        var animal3 = new Animal("Veiltail", Animal.Type.FISH, Animal.Sex.F, 9, 7, 0.36, true);
        var animal4 = new Animal("Tidal", Animal.Type.FISH, Animal.Sex.F, 7, 5, 0.56, true);
        var animal5 = new Animal("Mango", Animal.Type.BIRD, Animal.Sex.F, 13, 20, 0.64, false);
        var animal6 = new Animal("Fifi", Animal.Type.DOG, Animal.Sex.F, 11, 45, 27.00, false);
        var animal7 = new Animal("Alpha", Animal.Type.CAT, Animal.Sex.M, 12, 25, 7.00, true);
        var animal8 = new Animal("Oliver", Animal.Type.CAT, Animal.Sex.M, 5, 24, 4.00, true);
        var animal9 = new Animal("Rocky", Animal.Type.SPIDER, Animal.Sex.M, 13, 9, 0.09, true);
        var animal10 = new Animal("Petey", Animal.Type.BIRD, Animal.Sex.M, 5, 14, 0.75, false);

        var animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals)
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(List<Animal> animals) {
        // when
        var result = Task17.spiderMoreBitesThatDogs(animals);

        // then
        assertThat(result)
            .isEqualTo(true);

        // when
        result = Task17.spiderMoreBitesThatDogs(animals.subList(0, 8));

        // then
        assertThat(result)
            .isEqualTo(false);
    }

    static Stream<Arguments> notEnoughTestData() {
        return Stream.of(
            Arguments.of(List.of(new Animal("Carmel", Animal.Type.SPIDER, Animal.Sex.F, 12, 9, 0.06, true))),
            Arguments.of(List.of(new Animal("Arya", Animal.Type.DOG, Animal.Sex.F, 4, 81, 83.00, true))),
            Arguments.of(List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("notEnoughTestData")
    @DisplayName("Недостаточная информация")
    void notEnoughInfoTest(List<Animal> animals) {
        // when
        var result = Task17.spiderMoreBitesThatDogs(animals);

        // then
        assertThat(result)
            .isEqualTo(false);
    }
}
