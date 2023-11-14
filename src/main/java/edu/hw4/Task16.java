package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task16 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Sort the list of animals by (Animal.Type, Animal.Sex, Name)
     *
     * @param animals Animals
     * @return The sorted list of animals by (Animal.Type, Animal.Sex, Name)
     */
    static List<Animal> sortByTypeSexName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name))
            .toList();
    }

    public static void main(String[] args) {

        var animal1 = new Animal("Bailey", Animal.Type.BIRD, Animal.Sex.F, 15, 20, 0.64, true);
        var animal2 = new Animal("Mila", Animal.Type.CAT, Animal.Sex.F, 5, 24, 5.00, true);
        var animal3 = new Animal("Rin Fin Fin", Animal.Type.FISH, Animal.Sex.F, 3, 3, 0.31, false);
        var animal4 = new Animal("Oliver", Animal.Type.CAT, Animal.Sex.M, 16, 24, 7.00, true);
        var animal6 = new Animal("Jupiter", Animal.Type.FISH, Animal.Sex.M, 9, 5, 0.47, true);
        var animal7 = new Animal("Rudy", Animal.Type.DOG, Animal.Sex.M, 10, 63, 27.00, true);
        var animal8 = new Animal("Genevieve", Animal.Type.DOG, Animal.Sex.F, 9, 43, 43.00, true);
        var animal9 = new Animal("Peep", Animal.Type.BIRD, Animal.Sex.M, 5, 11, 0.61, false);
        var animal10 = new Animal("Hootie", Animal.Type.BIRD, Animal.Sex.F, 4, 14, 0.52, false);

        var animals = new ArrayList<>(List.of(
            animal1,
            animal2,
            animal3,
            animal4,
            animal6,
            animal7,
            animal8,
            animal9,
            animal10
        ));

        var list = sortByTypeSexName(animals);

        for (var elem : list) {
            LOGGER.info(elem);
        }
    }
}
