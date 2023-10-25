package edu.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BagOfWords {

    private final ArrayList<String> words = new ArrayList<>(List.of(new String[] {"toast",
        "replacement", "leftovers", "lift", "bolt", "offender", "mile", "deserve", "hang", "realism"}));

    private final Random random = new Random(System.currentTimeMillis());

    public String getWord() {
        int ind = random.nextInt(words.size());
        return words.get(ind);
    }
}
