package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * The animal with the longest name
     *
     * @param animals Animals
     * @return The animal with the longest name
     */
    static Animal longestNameAnimal(List<Animal> animals) throws IllegalArgumentException {
        if (animals.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: список животных не может быть пустым");
        }

        return animals.stream()
            .max(Comparator.comparingInt(a -> a.name().length()))
            .orElseThrow();
    }

    public static void main(String[] args) {

        var animal3 = new Animal("Chirpy", Animal.Type.BIRD, Animal.Sex.M, 7, 16, 0.23, true);
        var animal4 = new Animal("Indy", Animal.Type.BIRD, Animal.Sex.F, 11, 13, 0.90, true);
        var animal5 = new Animal("Fifi", Animal.Type.DOG, Animal.Sex.F, 12, 96, 61.00, true);
        var animal6 = new Animal("Moana", Animal.Type.FISH, Animal.Sex.F, 9, 9, 0.45, true);
        var animal7 = new Animal("Kai", Animal.Type.SPIDER, Animal.Sex.M, 25, 4, 0.14, false);
        var animal8 = new Animal("Oliver", Animal.Type.CAT, Animal.Sex.M, 11, 24, 6.00, false);
        var animal9 = new Animal("Otis", Animal.Type.CAT, Animal.Sex.M, 8, 24, 5.00, true);
        var animal10 = new Animal("Baby", Animal.Type.BIRD, Animal.Sex.M, 9, 13, 0.62, true);

        var animals = new ArrayList<>(List.of(
            animal3,
            animal4,
            animal5,
            animal6,
            animal7,
            animal8,
            animal9,
            animal10
        ));

        var animal = longestNameAnimal(animals);

        LOGGER.info(animal);
    }
}
