import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordCount {

    public Map<String, Integer> Phrase(String words) {
        return Arrays.asList(words.split("\\W+")).stream()                  // Split & stream \\w keep non word char, \\W does not \o/
                .filter(word -> !word.isEmpty())                            // Filter out empty
                .map(String::toLowerCase)                                   // Normalize it (lower case)
                .collect(wordCountCollectior());
    }

    private static Collector<String, ?, Map<String, Integer>> wordCountCollectior() {
        return Collectors.groupingBy(word -> word, counting());
    }

    // Collectors.counting() works on Long :(
    private static Collector<String, ?, Integer> counting() {
        return Collectors.reducing(0, word -> 1, Integer::sum);
    }
}