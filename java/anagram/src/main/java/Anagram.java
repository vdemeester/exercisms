import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Anagram {

    private final Map<Character, Integer> wordCharsMap;

    public Anagram(String word) {
        wordCharsMap = splitWordInCharacters(word);
    }

    private Map<Character, Integer> splitWordInCharacters(String word) {
        Map<Character, Integer> charactersMap = new HashMap<>();
        for (char character : word.toLowerCase().toCharArray()) {
            charactersMap.putIfAbsent(character, 0);
            charactersMap.compute(character, (c, value) -> ++value);
        }
        return charactersMap;
    }

    private boolean isAnagram(String word) {
        AtomicBoolean isAnagram = new AtomicBoolean(true);
        Map<Character, Integer> anagramMap = splitWordInCharacters(word);
        anagramMap.forEach((character, value) -> {
            if (!wordCharsMap.getOrDefault(character, 0).equals(value)) {
                isAnagram.set(false);
            }
        });
        return isAnagram.get();
    }

    public List<String> match(List<String> anagrams) {
        return anagrams.stream()
                .filter(this::isAnagram)
                .collect(Collectors.toList());
    }
}