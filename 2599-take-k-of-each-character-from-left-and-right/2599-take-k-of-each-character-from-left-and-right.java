class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] count = new int[3];
        int[] wind = new int[3];

        for(char c: s.toCharArray()) count[c-'a']++;

        for(int c: count) if(c < k) return -1;

        int l = 0, max = 0;

        for(int r = 0; r<n; r++) {
            wind[s.charAt(r) - 'a']++;

            while(l <= r && (count[0] - wind[0] < k || count[1] - wind[1] < k || count[2] - wind[2] < k)) {
                wind[s.charAt(l) - 'a']--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }

        return n - max;

    }
}