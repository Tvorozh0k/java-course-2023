package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task12 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * The number of animals with weight bigger than height
     *
     * @param animals Animals
     * @return The number of animals with weight bigger than height
     */
    static Integer weightBiggerHeight(List<Animal> animals) {
        return (int) animals.stream()
            .filter(a -> a.weight() > a.height())
            .count();
    }

    public static void main(String[] args) {

        var animal1 = new Animal("Otis", Animal.Type.CAT, Animal.Sex.M, 15, 24, 7.00, false);
        var animal2 = new Animal("Fifi", Animal.Type.DOG, Animal.Sex.F, 7, 20, 94.00, false);
        var animal3 = new Animal("Mango", Animal.Type.BIRD, Animal.Sex.F, 15, 16, 0.79, true);
        var animal4 = new Animal("Lacey", Animal.Type.CAT, Animal.Sex.F, 17, 25, 7.00, true);
        var animal5 = new Animal("Veiltail", Animal.Type.FISH, Animal.Sex.F, 8, 9, 0.59, false);
        var animal6 = new Animal("Tank", Animal.Type.DOG, Animal.Sex.M, 12, 64, 64.00, false);
        var animal7 = new Animal("Harley", Animal.Type.FISH, Animal.Sex.M, 3, 4, 0.26, false);
        var animal8 = new Animal("Alice", Animal.Type.CAT, Animal.Sex.F, 9, 25, 5.00, true);
        var animal9 = new Animal("Alpha", Animal.Type.CAT, Animal.Sex.M, 5, 23, 3.00, true);
        var animal10 = new Animal("Rio", Animal.Type.SPIDER, Animal.Sex.M, 6, 9, 0.08, true);

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

        var count = weightBiggerHeight(animals);

        LOGGER.info(count);
    }
}
