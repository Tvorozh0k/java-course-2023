package edu.hw4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task19 {

    private final static Logger LOGGER = LogManager.getLogger();

    private static Set<ValidationError> errorsAnimal(Animal animal) {
        Set<ValidationError> result = new HashSet<>();

        if (animal.name().isBlank()) {
            result.add(new ValidationError(ValidationError.ErrorType.WRONG_NAME));
        }

        if (animal.age() <= 0) {
            result.add(new ValidationError(ValidationError.ErrorType.WRONG_AGE));
        }

        if (animal.height() <= 0) {
            result.add(new ValidationError(ValidationError.ErrorType.WRONG_HEIGHT));
        }

        if (animal.weight() <= 0) {
            result.add(new ValidationError(ValidationError.ErrorType.WRONG_WEIGHT));
        }

        return result;
    }

    /**
     * The map of animals with their errors
     *
     * @param animals The lists of animals
     * @return The map of animals with their errors
     */
    static Map<String, Set<ValidationError>> errorsAnimals(List<Animal> animals) throws IllegalArgumentException {
        if (animals.stream().map(Animal::name).collect(Collectors.toSet()).size() < animals.size()) {
            throw new IllegalArgumentException("Ошибка: имена животных должны быть уникальными");
        }

        return animals.stream()
            .collect(Collectors.toMap(Animal::name, Task19::errorsAnimal))
            .entrySet()
            .stream().filter(a -> !a.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {

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

        var animals = new ArrayList<>(List.of(
            animal1,
            animal2,
            animal3,
            animal4,
            animal5,
            animal6,
            animal7,
            animal8,
            animal9,
            animal10
        ));

        var dict = errorsAnimals(animals);

        for (var elem : dict.entrySet()) {
            LOGGER.info(elem);
        }
    }
}
