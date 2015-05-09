import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> result = new HashMap<>();
        old.forEach((value, letters) -> letters.forEach(letter -> result.put(letter.toLowerCase(), value)));
        return result;
    }
}
