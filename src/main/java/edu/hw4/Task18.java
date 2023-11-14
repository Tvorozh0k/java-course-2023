package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task18 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * The heaviest fish among all lists of animals
     *
     * @param lists The lists of animals
     * @return The heaviest fish among all lists of animals
     */
    @SafeVarargs static Animal heaviestFish(List<Animal>... lists) {
        return Stream.of(lists)
            .flatMap(List::stream)
            .filter(a -> a.type().equals(Animal.Type.FISH))
            .max(Comparator.comparing(Animal::weight))
            .orElse(null);
    }

    public static void main(String[] args) {

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

        var animals1 = new ArrayList<>(List.of(
            animal1,
            animal2,
            animal3,
            animal4,
            animal5
        ));

        var animals2 = new ArrayList<>(List.of(
            animal6,
            animal7,
            animal8,
            animal9,
            animal10
        ));

        var fish = heaviestFish(animals1, animals2);

        LOGGER.info(fish);
    }
}
