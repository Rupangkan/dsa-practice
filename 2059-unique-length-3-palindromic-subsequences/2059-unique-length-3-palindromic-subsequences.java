class Solution {
    
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        int n = s.length(), ans = 0;
        Arrays.fill(first, -1);

        for(int i = 0; i<n; i++) {
            int curr = s.charAt(i) - 'a';
            if(first[curr] == -1) first[curr] = i;
            last[curr] = i;
        }
        for(int i = 0; i<26; i++) {
            if(first[i] == -1) continue;
            Set<Character> bet = new HashSet<>();
            for(int j = first[i] + 1; j<last[i]; j++) bet.add(s.charAt(j));
            ans += bet.size();
        }
        return ans;

    }
}