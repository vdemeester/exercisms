import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String, Integer> Phrase(String words) {
        Map<String, Integer> wordsCount = new HashMap<>();
        Arrays.asList(words.split(" ")).stream()                            // Split & stream
                .map(word -> word.replaceAll("[^a-zA-Z0-9]", ""))           // Remove non alpha-numeric characters
                .filter(word -> !word.isEmpty())                            // Filter out empty
                .map(String::toLowerCase)                                   // Normalize it (lower case)
                .forEach(word -> {
                    wordsCount.putIfAbsent(word, 0);                        // Initialize if absent
                    wordsCount.compute(word, (sameWord, value) -> ++value); // Increment it
                });
        return wordsCount;
    }
}