package challenges.ransomnote;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> mapRansomChars = mapChars(ransomNote);
        Map<String, Integer> mapMagChars = mapChars(magazine);
        System.out.println(mapRansomChars);
        System.out.println(mapMagChars);
        boolean result = true;

        for(Map.Entry<String, Integer> entry : mapRansomChars.entrySet()) {
            int magCharCount = mapMagChars.get(entry.getKey()) == null ? 0 : mapMagChars.get(entry.getKey());
            if (magCharCount == 0) {
                result = false;
                break;
            } else {
                if (magCharCount >= entry.getValue()) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static Map<String, Integer> mapChars(String characters) {
        String[] ransomChars = characters.split("");
        HashMap<String, Integer> uniqueCharsCount = new HashMap<String, Integer>();
        for (String ranscomChar: ransomChars) {
            uniqueCharsCount.merge(ranscomChar, 1, Integer::sum);
        }
        return uniqueCharsCount;
    }
}
