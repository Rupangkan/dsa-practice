class Solution {
    public List<String> wordSubsets(String[] words, String[] patterns) {
        int[] maxPatternFrequency = calculateFrequency("");
        
        for (String pattern : patterns) {
            int[] patternFrequency = calculateFrequency(pattern);
            for (int i = 0; i < 26; ++i) {
                maxPatternFrequency[i] = Math.max(maxPatternFrequency[i], patternFrequency[i]);
            }
        }

        List<String> universalWords = new ArrayList<>();

        outerLoop: for (String word : words) {
            int[] wordFrequency = calculateFrequency(word);
            for (int i = 0; i < 26; ++i) {
                if (wordFrequency[i] < maxPatternFrequency[i]) {
                    continue outerLoop;
                }
            }
            universalWords.add(word);
        }

        return universalWords;
    }

    public int[] calculateFrequency(String str) {
        int[] frequency = new int[26];
        for (char ch : str.toCharArray()) {
            frequency[ch - 'a']++;
        }
        return frequency;
    }
}
