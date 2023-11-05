package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.util.stream.Collectors.groupingBy;

public class Task15 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Find the total mass of animals of each species that are between k and l years old
     *
     * @param animals Animals
     * @param k       Lower bound of age
     * @param l       Upper bound of age
     * @return The dict of sums of animals weights by their species
     */
    static Map<Animal.Type, Double> sumWeightsByType(List<Animal> animals, int k, int l) throws IllegalArgumentException {
        if (k <= 0 || l <= 0 || k > l) {
            throw new IllegalArgumentException("Ошибка: k и l должны уд-ть след. ограничениям: k > 0, l > 0 и k <= l");
        }

        return animals.stream()
            .filter(a -> a.age() >= k && a.age() <= l)
            .collect(groupingBy(Animal::type, Collectors.summingDouble(Animal::weight)));
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

        var dict = sumWeightsByType(animals, 5, 10);

        for (var type : dict.entrySet()) {
            LOGGER.info(type);
        }
    }
}
