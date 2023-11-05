package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task13 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Animals with names consisting of 2 or more words
     *
     * @param animals Animals
     * @return The list of animals with names consisting of 2 or more words
     */
    static List<Animal> fewWordsNameAnimals(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.name().split(" ").length >= 2)
            .toList();
    }

    public static void main(String[] args) {

        var animal1 = new Animal("Caspian", Animal.Type.FISH, Animal.Sex.F, 6, 9, 0.38, false);
        var animal2 = new Animal("Rin Fin Fin", Animal.Type.FISH, Animal.Sex.F, 5, 2, 0.56, false);
        var animal3 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 8, 47, 34.00, true);
        var animal4 = new Animal("Lucy", Animal.Type.BIRD, Animal.Sex.F, 7, 12, 0.83, true);
        var animal5 = new Animal("Bailey", Animal.Type.BIRD, Animal.Sex.F, 14, 14, 0.41, false);
        var animal6 = new Animal("Midnight", Animal.Type.SPIDER, Animal.Sex.M, 25, 7, 0.08, true);
        var animal7 = new Animal("Gigi", Animal.Type.CAT, Animal.Sex.F, 11, 25, 7.00, true);
        var animal8 = new Animal("Remington", Animal.Type.DOG, Animal.Sex.M, 5, 34, 71.00, true);
        var animal9 = new Animal("Queen", Animal.Type.CAT, Animal.Sex.F, 12, 24, 7.00, false);
        var animal10 = new Animal("Rainbow Fish", Animal.Type.FISH, Animal.Sex.F, 4, 4, 0.52, true);

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

        var filter = fewWordsNameAnimals(animals);

        for (var elem : filter) {
            LOGGER.info(elem);
        }
    }
}
