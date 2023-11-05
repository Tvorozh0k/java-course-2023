package edu.hw4;

import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask2 {

    static Stream<Arguments> ExamplesData() {

        var animal1 = new Animal("Baby", Animal.Type.BIRD, Animal.Sex.M, 8, 16, 0.32, true);
        var animal2 = new Animal("Rin Fin Fin", Animal.Type.FISH, Animal.Sex.F, 5, 4, 0.38, false);
        var animal3 = new Animal("Ellie", Animal.Type.DOG, Animal.Sex.F, 10, 17, 30.00, false);
        var animal4 = new Animal("Arthur", Animal.Type.BIRD, Animal.Sex.M, 7, 19, 0.74, true);
        var animal5 = new Animal("Lacey", Animal.Type.CAT, Animal.Sex.F, 15, 24, 4.00, true);
        var animal6 = new Animal("Foxy", Animal.Type.DOG, Animal.Sex.F, 10, 81, 83.00, true);
        var animal7 = new Animal("Ziggy", Animal.Type.SPIDER, Animal.Sex.M, 13, 4, 0.07, true);
        var animal8 = new Animal("Itsy", Animal.Type.SPIDER, Animal.Sex.M, 16, 11, 0.13, false);
        var animal9 = new Animal("Otis", Animal.Type.CAT, Animal.Sex.M, 17, 24, 4.00, true);
        var animal10 = new Animal("Zeus", Animal.Type.CAT, Animal.Sex.M, 5, 25, 4.00, true);

        var animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals, 4)
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(List<Animal> animals, int k) {
        // when

        var result = Task2.sortByWeight(animals, k);

        // then

        // check if lists are equal without order

        assertThat(animals.containsAll(result))
            .isTrue();

        // checking the order using weight lists

        assertThat(animals.stream().map(Animal::weight).sorted(Comparator.reverseOrder()).limit(k).toList())
            .isEqualTo(result.stream().map(Animal::weight).toList());
    }

    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Некорректные входные данные")
    void IncorrectInputTests(List<Animal> animals) {
        // then
        for (int k : List.of(-1, 11)) {
            assertThatThrownBy(() -> Task2.sortByWeight(animals, k))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
