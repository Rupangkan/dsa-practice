class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> matchingWords = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int[] lps = computeLPS(words[i]);
            for (int j = 0; j < n; j++) {
                if (i != j && isSubstring(words[i], words[j], lps)) {
                    matchingWords.add(words[i]);
                    break;
                }
            }
        }

        return matchingWords;
    }

    private static int[] computeLPS(String sub) {
        int[] lps = new int[sub.length()];
        int len = 0, i = 1;

        while (i < sub.length()) {
            if (sub.charAt(i) == sub.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                i++;
            }
        }
        return lps;
    }

    private static boolean isSubstring(String sub, String main, int[] lps) {
        int i = 0, j = 0;

        while (i < main.length()) {
            if (main.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
                if (j == sub.length()) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return false;
    }
}