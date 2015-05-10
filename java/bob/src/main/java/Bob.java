public class Bob {

    public static final String WHATEVER = "Whatever.";
    public static final String FINE_BE_THAT_WAY = "Fine. Be that way!";
    public static final String WHOA_CHILL_OUT = "Whoa, chill out!";
    public static final String SURE = "Sure.";

    public String hey(String sentence) {
        String normalizedSentence = normalizeSentence(sentence);
        if (isNothing(normalizedSentence)) {
            return FINE_BE_THAT_WAY;
        } else if (isShout(normalizedSentence)) {
            return WHOA_CHILL_OUT;
        } else if (isQuestion(normalizedSentence)) {
            return SURE;
        }
        return WHATEVER;
    }

    private boolean isNothing(String sentence) {
        return sentence == null || sentence.isEmpty();
    }

    private boolean isShout(String sentence) {
        String cleanedSentence = normalizeSentence(sentence.replaceAll("[,0-9?]", ""));
        if (cleanedSentence.isEmpty()) {
            return false;
        }
        return cleanedSentence.equals(cleanedSentence.toUpperCase());
    }

    private boolean isQuestion(String sentence) {
        return sentence.endsWith("?");
    }

    private String normalizeSentence(String sentence) {
        return sentence.trim();
    }
}
