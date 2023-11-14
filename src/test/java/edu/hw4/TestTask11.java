package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask11 {

    static Stream<Arguments> ExamplesData() {

        var animal1 = new Animal("Caspian", Animal.Type.FISH, Animal.Sex.F, 8, 2, 0.38, true);
        var animal2 = new Animal("Queenie", Animal.Type.CAT, Animal.Sex.F, 11, 23, 4.00, true);
        var animal3 = new Animal("Bandit", Animal.Type.CAT, Animal.Sex.M, 10, 23, 7.00, true);
        var animal4 = new Animal("Indy", Animal.Type.BIRD, Animal.Sex.F, 9, 10, 0.20, true);
        var animal5 = new Animal("Marley", Animal.Type.SPIDER, Animal.Sex.F, 22, 5, 0.08, true);
        var animal6 = new Animal("Midnight", Animal.Type.SPIDER, Animal.Sex.F, 18, 4, 0.09, false);
        var animal7 = new Animal("Bubbles", Animal.Type.FISH, Animal.Sex.M, 10, 10, 0.32, false);
        var animal8 = new Animal("Arthur", Animal.Type.BIRD, Animal.Sex.M, 8, 16, 0.64, true);
        var animal9 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 8, 115, 50.00, true);
        var animal10 = new Animal("Josie", Animal.Type.DOG, Animal.Sex.F, 10, 103, 50.00, false);

        var animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals, List.of(animal9))
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(List<Animal> animals, List<Animal> expected) {
        // when

        var result = Task11.bitesAndTall(animals);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
