class Solution {
    public int smallestRepunitDivByK(int K) {
        int r = 0;
        for (int len = 1; len <= K; len++) {
            r = (r * 10 + 1) % K;
            if (r == 0) return len;
        }
        return -1;
    }
}
