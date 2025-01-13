class Solution {
    public int minimumLength(String input) {
        int[] charCount = new int[26];
        int minLength = 0;

        for (char ch : input.toCharArray()) {
            charCount[ch - 'a']++;
        }

        for (int count : charCount) {
            if (count == 0) continue; 
            minLength += (count % 2 == 0) ? 2 : 1; 
        }

        return minLength;
    }
}