package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask20 {

    static Stream<Arguments> ExamplesData() {

        var animal1 = new Animal("", Animal.Type.FISH, Animal.Sex.F, 4, -2, 0.14, false);
        var animal2 = new Animal("Marley", Animal.Type.CAT, Animal.Sex.M, 11, -2, -3.00, false);
        var animal3 = new Animal("Lacey", Animal.Type.CAT, Animal.Sex.F, 8, 24, 7.00, false);
        var animal4 = new Animal("Rainbow Fish", Animal.Type.FISH, Animal.Sex.M, -1, -2, -3.00, true);
        var animal5 = new Animal("Bailey", Animal.Type.BIRD, Animal.Sex.F, 9, 18, 0.74, true);
        var animal6 = new Animal("Dexter", Animal.Type.DOG, Animal.Sex.M, 13, 55, 55.00, true);
        var animal7 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 13, 15, 91.00, true);
        var animal8 = new Animal("Sammy", Animal.Type.BIRD, Animal.Sex.F, 14, 12, 0.98, false);
        var animal9 = new Animal("Sushi", Animal.Type.FISH, Animal.Sex.M, 4, 8, 0.28, false);
        var animal10 = new Animal("Pumpkin", Animal.Type.BIRD, Animal.Sex.M, 4, 13, 0.82, true);

        var animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals, Map.of("", "Имя должно содержать хотя бы один непробельный символ, рост должен быть больше нуля",
                "Marley", "Вес должен быть больше нуля, рост должен быть больше нуля",
                "Rainbow Fish", "Вес должен быть больше нуля, возраст должен быть больше нуля, рост должен быть больше нуля"))
        );
    }


    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(List<Animal> animals, Map<String, String> expected) {
        // when
        var result = Task20.errorsAnimals(animals);

        var lol = result.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
            a -> Arrays.stream(a.getValue().toLowerCase().split(", ")).collect(Collectors.toSet())));

        // then
        assertThat(result.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                a -> Arrays.stream(a.getValue().toLowerCase().split(", ")).collect(Collectors.toSet()))))
            .isEqualTo(expected.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                a -> Arrays.stream(a.getValue().toLowerCase().split(", ")).collect(Collectors.toSet()))));
    }

    static Stream<Arguments> ErrorTestData() {

        var animal1 = new Animal("", Animal.Type.FISH, Animal.Sex.F, -6, -9, 0.38, false);
        var animal2 = new Animal("Rin Fin Fin", Animal.Type.FISH, Animal.Sex.F, 5, 2, 0.56, false);
        var animal3 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 8, -47, 34.00, true);
        var animal4 = new Animal("", Animal.Type.BIRD, Animal.Sex.F, 7, -12, 0.83, true);
        var animal5 = new Animal("Bailey", Animal.Type.BIRD, Animal.Sex.F, 14, 14, 0.41, false);
        var animal6 = new Animal("Midnight", Animal.Type.SPIDER, Animal.Sex.M, -25, 7, 0.08, true);
        var animal7 = new Animal("Gigi", Animal.Type.CAT, Animal.Sex.F, 11, 25, 7.00, true);
        var animal8 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 5, 34, 71.00, true);
        var animal9 = new Animal("Queen", Animal.Type.CAT, Animal.Sex.F, 12, 24, 7.00, false);
        var animal10 = new Animal("Rainbow Fish", Animal.Type.FISH, Animal.Sex.F, 4, 4, 0.52, true);

        var animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10);

        return Stream.of(
            Arguments.of(animals)
        );
    }

    @ParameterizedTest
    @MethodSource("ErrorTestData")
    @DisplayName("Животные с одинаковыми именами")
    void SameNamesTest(List<Animal> animals) {
        // then
        assertThatThrownBy(() -> Task20.errorsAnimals(animals))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
