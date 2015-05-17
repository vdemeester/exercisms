import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Bob {

    public static final ConditionalAnswer WHATEVER_ANSWER = new ConditionalAnswer(anySentence -> true, "Whatever.");
    private static final Condition isNothing = sentence -> sentence == null || sentence.isEmpty();
    private static final Condition isQuestion = sentence -> sentence.endsWith("?");
    private static final Condition isShout = sentence -> {
        String cleanedSentence = normalizeSentence(sentence.replaceAll("[,0-9?]", ""));
        return !cleanedSentence.isEmpty() && cleanedSentence.equals(cleanedSentence.toUpperCase());
    };

    private List<ConditionalAnswer> conditions = new LinkedList<>();

    // The "final" touch would be to be able to pass a list of conditions to Bob :)
    public Bob() {
        conditions.add(new ConditionalAnswer(isNothing, "Fine. Be that way!"));
        conditions.add(new ConditionalAnswer(isShout, "Whoa, chill out!"));
        conditions.add(new ConditionalAnswer(isQuestion, "Sure."));
    }

    public String hey(String sentence) {
        String normalizedSentence = normalizeSentence(sentence);
        return conditions.stream()
                .filter(conditionalAnswer -> conditionalAnswer.condition.test(normalizedSentence))
                .findFirst()
                .orElse(WHATEVER_ANSWER)
                .answer();
    }

    // Just sugar :)
    public interface Condition extends Predicate<String> {}

    // This wouldn't probably be a inner class ;-P
    public static class ConditionalAnswer {

        private final Condition condition;
        private final String answer;

        public ConditionalAnswer(Condition condition, String answer) {
            this.condition = condition;
            this.answer = answer;
        }

        public String answer() {
            return answer;
        }
    }

    private static String normalizeSentence(String sentence) {
        return sentence.trim();
    }
}
