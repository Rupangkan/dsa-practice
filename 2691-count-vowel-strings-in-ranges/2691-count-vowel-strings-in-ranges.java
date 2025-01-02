class Solution {
    public int[] vowelStrings(String[] words, int[][] q) {
        int[] ans = new int[q.length];
        HashSet<Character> v = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] prefix = new int[words.length];
        int sum = 0;

        for(int i = 0; i<words.length; i++) {
            String curr = words[i];
            if(v.contains(curr.charAt(0)) && v.contains(curr.charAt(curr.length() - 1))) {
                sum++;
            } 
            prefix[i] = sum;
        }

        for(int i = 0; i<q.length; i++) {
            int[] curr = q[i];
            ans[i] = prefix[curr[1]] - (curr[0] == 0 ? 0 : prefix[curr[0] - 1]);
        }
        
        return ans;
    }
}