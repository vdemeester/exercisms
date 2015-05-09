import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DNA {

    private static Character[] symbols = new Character[]{'A', 'C', 'G', 'T'};
    Map<Character, Integer> nucleotideCount = new HashMap<>();

    public DNA(String dna) {
        populateMapWithDefaultSymbols();
        parseDnaStringAndCountSymbols(dna);
    }

    private void parseDnaStringAndCountSymbols(String dna) {
        for (char dnaChar : dna.toCharArray()) {
            nucleotideCount.compute(dnaChar, (character, integer) -> ++integer);
        }
    }

    private void populateMapWithDefaultSymbols() {
        for (Character symbol : symbols) {
            nucleotideCount.put(symbol, 0);
        }
    }

    public Integer count(char symbol) {
        if (!Arrays.asList(symbols).contains(symbol)) {
            throw new IllegalArgumentException("Illegal symbol");
        }
        return nucleotideCount.getOrDefault(symbol, 0);
    }

    public Map<Character, Integer> nucleotideCounts() {
        return nucleotideCount;
    }
}