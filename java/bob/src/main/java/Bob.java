import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Bob {

    private List<ConditionalAnswer> conditions = new LinkedList<>();

    public static final String WHATEVER = "Whatever.";
    public static final String FINE_BE_THAT_WAY = "Fine. Be that way!";
    public static final String WHOA_CHILL_OUT = "Whoa, chill out!";
    public static final String SURE = "Sure.";

    // The "final" touch would be to be able to pass a list of conditions to Bob :)
    public Bob() {
        conditions.add(new ConditionalAnswer(isNothing, FINE_BE_THAT_WAY));
        conditions.add(new ConditionalAnswer(isShout, WHOA_CHILL_OUT));
        conditions.add(new ConditionalAnswer(isQuestion, SURE));
    }

    public String hey(String sentence) {
        String normalizedSentence = normalizeSentence(sentence);
        return conditions.stream()
                .filter(conditionalAnswer -> conditionalAnswer.predicate.test(normalizedSentence))
                .findFirst()
                .orElse(new ConditionalAnswer(anySentence -> true, WHATEVER))
                .answer();
    }

    private static final Predicate<String> isNothing = sentence -> sentence == null || sentence.isEmpty();
    private static final Predicate<String> isShout = sentence -> {
        String cleanedSentence = normalizeSentence(sentence.replaceAll("[,0-9?]", ""));
        return !cleanedSentence.isEmpty() && cleanedSentence.equals(cleanedSentence.toUpperCase());
    };
    private static final Predicate<String> isQuestion = sentence -> sentence.endsWith("?");

    private static String normalizeSentence(String sentence) {
        return sentence.trim();
    }

    // This wouldn't probably be a inner class ;-P
    public static class ConditionalAnswer {

        private final Predicate<String> predicate;
        private final String answer;

        public ConditionalAnswer(Predicate<String> predicate, String answer) {
            this.predicate = predicate;
            this.answer = answer;
        }

        public String answer() {
            return answer;
        }
    }
}
