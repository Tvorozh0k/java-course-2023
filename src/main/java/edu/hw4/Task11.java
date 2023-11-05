package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task11 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Animals that bite and are taller than 100 cm
     *
     * @param animals Animals
     * @return The list of animals that bite and are taller than 100 cm
     */
    static List<Animal> bitesAndTall(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.bites() && a.height() > 100)
            .toList();
    }

    public static void main(String[] args) {

        var animal1 = new Animal("Caspian", Animal.Type.FISH, Animal.Sex.F, 8, 2, 0.38, true);
        var animal2 = new Animal("Queenie", Animal.Type.CAT, Animal.Sex.F, 11, 23, 4.00, true);
        var animal3 = new Animal("Bandit", Animal.Type.CAT, Animal.Sex.M, 10, 23, 7.00, true);
        var animal4 = new Animal("Indy", Animal.Type.BIRD, Animal.Sex.F, 9, 10, 0.20, true);
        var animal5 = new Animal("Marley", Animal.Type.SPIDER, Animal.Sex.F, 22, 5, 0.08, true);
        var animal6 = new Animal("Midnight", Animal.Type.SPIDER, Animal.Sex.F, 18, 4, 0.09, false);
        var animal7 = new Animal("Bubbles", Animal.Type.FISH, Animal.Sex.M, 10, 10, 0.32, false);
        var animal8 = new Animal("Arthur", Animal.Type.BIRD, Animal.Sex.M, 8, 16, 0.64, true);
        var animal9 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 8, 115, 50.00, true);
        var animal10 = new Animal("Josie", Animal.Type.DOG, Animal.Sex.F, 10, 103, 50.00, false);

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

        var filter = bitesAndTall(animals);

        for (var elem : filter) {
            LOGGER.info(elem);
        }
    }
}
