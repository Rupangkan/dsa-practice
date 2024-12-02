class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split("\\s+");

        int n = searchWord.length();
        for(int i = 0; i<strs.length; i++) {
            boolean match = false;
            if(strs[i].length() < searchWord.length()) continue;
            for(int j = 0; j<n; j++) {
                char curr = strs[i].charAt(j);
                char matchChar = searchWord.charAt(j);
                if(curr == matchChar) match = true;
                else {
                    match = false;
                    break;
                }
            }
            if(match) return i+1;
        }
        return -1;
    }
}