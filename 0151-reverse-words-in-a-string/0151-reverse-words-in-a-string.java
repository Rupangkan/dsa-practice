class Solution {
    public String reverseWords(String s) {

        int n = s.length() - 1;
        StringBuilder ans = new StringBuilder();

        while(n>=0) {
            while(n >= 0 && s.charAt(n) == ' ') n--;
            if(n < 0) break;
            int end = n;
            while(n >= 0 && s.charAt(n) != ' ') n--;
            String word = s.substring(n+1, end+1);
            
            if(ans.length() > 0) {
                ans.append(" ");
            }
            ans.append(word);
        }
        return ans.toString();
    }
}