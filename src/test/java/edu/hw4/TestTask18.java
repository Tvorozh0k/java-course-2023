package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask18 {

    static Stream<Arguments> ExamplesData() {

        var animal1 = new Animal("Tidal", Animal.Type.FISH, Animal.Sex.F, 4, 8, 0.14, false);
        var animal2 = new Animal("Marley", Animal.Type.CAT, Animal.Sex.M, 11, 24, 4.00, false);
        var animal3 = new Animal("Lacey", Animal.Type.CAT, Animal.Sex.F, 8, 24, 7.00, false);
        var animal4 = new Animal("Rainbow Fish", Animal.Type.FISH, Animal.Sex.M, 10, 8, 0.25, true);
        var animal5 = new Animal("Bailey", Animal.Type.BIRD, Animal.Sex.F, 9, 18, 0.74, true);
        var animal6 = new Animal("Dexter", Animal.Type.DOG, Animal.Sex.M, 13, 55, 55.00, true);
        var animal7 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 13, 15, 91.00, true);
        var animal8 = new Animal("Sammy", Animal.Type.BIRD, Animal.Sex.F, 14, 12, 0.98, false);
        var animal9 = new Animal("Sushi", Animal.Type.FISH, Animal.Sex.M, 4, 8, 0.28, false);
        var animal10 = new Animal("Pumpkin", Animal.Type.BIRD, Animal.Sex.M, 4, 13, 0.82, true);

        var animals1 = List.of(animal1, animal2, animal3, animal4, animal5);
        var animals2 = List.of(animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals1, animals2)
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию") final void Examples(List<Animal> animals1, List<Animal> animals2) {
        // when
        var result = Task18.heaviestFish(animals1, animals2);

        // then
        assertThat(result)
            .isEqualTo(new Animal("Sushi", Animal.Type.FISH, Animal.Sex.M, 4, 8, 0.28, false));
    }

    static Stream<Arguments> NullAnswerTestData() {

        var animal2 = new Animal("Marley", Animal.Type.CAT, Animal.Sex.M, 11, 24, 4.00, false);
        var animal3 = new Animal("Lacey", Animal.Type.CAT, Animal.Sex.F, 8, 24, 7.00, false);
        var animal5 = new Animal("Bailey", Animal.Type.BIRD, Animal.Sex.F, 9, 18, 0.74, true);

        var animals1 = List.of(animal2, animal3, animal5);

        return Stream.of(
            Arguments.of(animals1)
        );
    }

    @ParameterizedTest
    @MethodSource("NullAnswerTestData")
    @DisplayName("Нет рыб") final void NullAnswerTest(List<Animal> animals1) {
        // when
        var result = Task18.heaviestFish(animals1);

        // then
        assertThat(result)
            .isEqualTo(null);
    }
}
