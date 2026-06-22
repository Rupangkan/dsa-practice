class Solution {

    public int maxNumberOfBalloons(String s) {

        int[] cnt = new int[5];
        String t = "balon";

        for (char c : s.toCharArray()) {
            for (int i = 0; i < 5; i++) {
                if (c == t.charAt(i)) {
                    cnt[i]++;
                }
            }
        }

        cnt[2] /= 2;
        cnt[3] /= 2;

        int ans = Integer.MAX_VALUE;

        for (int x : cnt) {
            ans = Math.min(ans, x);
        }

        return ans;
    }
}