import java.util.Random;

public class Robot {

    private static final Random rng = new Random();

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String DIGITS = "1234567890";
    
    private String name;

    // RX837
    public Robot() {
        name = generateName();
    }

    private String generateName() {
        return generate(ALPHABET, 2) + generate(DIGITS, 3);
    }

    private String generate(String allowedCharacters, int size) {
        char[] text = new char[size];
        for (int i = 0; i < size; i++) {
            text[i] = allowedCharacters.charAt(rng.nextInt(allowedCharacters.length()));
        }
        return new String(text);
    }

    // Return the Robot name
    public String getName() {
        return this.name;
    }

    // Reset the name
    public void reset() {
        this.name = generateName();
    }
}