public class Hamming {
    public static Integer compute(String sequence1, String sequence2) {
        if (sequence1.length() != sequence2.length()) {
            throw new IllegalArgumentException("The 2 DNA sequence should have the same length");
        }
        int hammingDistance = 0;
        for (int index = 0; index < sequence1.length(); index++) {
            if (sequence1.charAt(index) != sequence2.charAt(index)) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }
}
