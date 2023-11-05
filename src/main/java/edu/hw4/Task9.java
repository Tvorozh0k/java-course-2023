package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task9 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * The sum of animals paws
     *
     * @param animals Animals
     * @return The sum of animals paws
     */
    static Integer sumPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static void main(String[] args) {

        var animal1 = new Animal("Baby", Animal.Type.BIRD, Animal.Sex.M, 8, 16, 0.32, true);
        var animal2 = new Animal("Rin Fin Fin", Animal.Type.FISH, Animal.Sex.F, 5, 4, 0.38, false);
        var animal3 = new Animal("Ellie", Animal.Type.DOG, Animal.Sex.F, 10, 17, 30.00, false);
        var animal4 = new Animal("Arthur", Animal.Type.BIRD, Animal.Sex.M, 7, 19, 0.74, true);
        var animal5 = new Animal("Lacey", Animal.Type.CAT, Animal.Sex.F, 15, 24, 4.00, true);
        var animal6 = new Animal("Foxy", Animal.Type.DOG, Animal.Sex.F, 10, 81, 83.00, true);
        var animal7 = new Animal("Ziggy", Animal.Type.SPIDER, Animal.Sex.M, 13, 4, 0.07, true);
        var animal8 = new Animal("Itsy", Animal.Type.SPIDER, Animal.Sex.M, 16, 11, 0.13, false);
        var animal9 = new Animal("Otis", Animal.Type.CAT, Animal.Sex.M, 17, 24, 5.00, true);
        var animal10 = new Animal("Moana", Animal.Type.FISH, Animal.Sex.F, 9, 9, 0.45, true);

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

        var count = sumPaws(animals);

        LOGGER.info(count);
    }
}
