package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Sort the animals in ascending order by their height
     *
     * @param animals Animals
     * @return The list of animals in ascending order by their height
     */
    static List<Animal> sortByHeight(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static void main(String[] args) {
        var animal1 = new Animal("Arizona", Animal.Type.SPIDER, Animal.Sex.F, 5, 4, 0.10, true);
        var animal2 = new Animal("Ziggy", Animal.Type.SPIDER, Animal.Sex.M, 8, 13, 0.12, false);
        var animal3 = new Animal("Moana", Animal.Type.FISH, Animal.Sex.F, 4, 4, 0.52, true);
        var animal4 = new Animal("Fifi", Animal.Type.DOG, Animal.Sex.F, 12, 96, 61.00, true);
        var animal5 = new Animal("Alice", Animal.Type.CAT, Animal.Sex.F, 8, 24, 7.00, true);
        var animal6 = new Animal("Arya", Animal.Type.DOG, Animal.Sex.F, 6, 59, 67.00, true);
        var animal7 = new Animal("Marley", Animal.Type.SPIDER, Animal.Sex.F, 23, 4, 0.13, true);
        var animal8 = new Animal("Annie", Animal.Type.CAT, Animal.Sex.F, 9, 23, 6.00, true);
        var animal9 = new Animal("Harley", Animal.Type.FISH, Animal.Sex.M, 4, 10, 0.22, false);
        var animal10 = new Animal("Queenie", Animal.Type.CAT, Animal.Sex.F, 15, 24, 6.00, true);

        var animals = new ArrayList<>(List.of(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10));

        animals = new ArrayList<>(sortByHeight(animals));

        for (var obj : animals) {
            LOGGER.info(String.format("%d %s", obj.height(), obj));
        }
    }
}
