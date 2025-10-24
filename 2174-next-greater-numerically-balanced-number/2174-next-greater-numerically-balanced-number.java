class Solution {
    public int nextBeautifulNumber(int n) {
        for (int x = n + 1; x <= 1224444; x++) {
            if (isValid(x)) return x;
        }
        return -1;
    }

    private boolean isValid(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        for (int d = 0; d < 10; d++) {
            if (freq[d] > 0 && freq[d] != d) return false;
        }
        return true;
    }
}
