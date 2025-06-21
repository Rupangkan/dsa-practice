class Solution {
    private int solve(String word, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : word.toCharArray()) freq.merge(c, 1, Integer::sum);
        int ans = word.length();
        for (int base : freq.values()) {
            int del = 0;
            for (int comp : freq.values()) {
                if (comp < base) del += comp;
                else if (comp > base + k) del += comp - (base + k);
            }
            ans = Math.min(ans, del);
        }
        return ans;
    }

    public int minimumDeletions(String word, int k) {
        return solve(word, k);
    }
}