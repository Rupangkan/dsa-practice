class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;
        int n = s.length();
        int ans = 0;
        int[] count = new int[26];

        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        for(int i = 0; i<t; i++) {
            int[] newC = new int[26];

            for(int j = 0; j<25; j++) {
                newC[j+1] = count[j];
            }

            newC[0] = count[25];
            newC[1] = (newC[1] + count[25]) % mod;

            count = newC;
        }

        for(int a: count) {
            ans = (ans + a) % mod;
        }
        return ans;   
    }
}