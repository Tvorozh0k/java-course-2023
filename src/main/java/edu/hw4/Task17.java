package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task17 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Check if spiders are more capable of biting than dogs
     *
     * @param animals Animals
     * @return true if spiders are more capable of biting than dogs, else - false
     */
    static Boolean spiderMoreBitesThatDogs(List<Animal> animals) {
        var spidersCount = animals.stream()
            .filter(a -> a.type().equals(Animal.Type.SPIDER) && a.bites())
            .count();

        var dogsCount = animals.stream()
            .filter(a -> a.type().equals(Animal.Type.DOG) && a.bites())
            .count();

        return spidersCount > dogsCount && dogsCount > 0;
    }

    public static void main(String[] args) {

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

        var b = spiderMoreBitesThatDogs(animals);

        LOGGER.info(b);
    }
}
