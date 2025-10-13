import java.util.*;

class Solution {

    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prevSignature = "";

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String currentSignature = new String(chars);

            if (!currentSignature.equals(prevSignature)) {
                result.add(word);
                prevSignature = currentSignature;
            }
        }

        return result;
    }
}
