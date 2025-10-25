class Solution {
    public int totalMoney(int n) {
        int res = 0, start = 1;
        while (n > 0) {
            int days = Math.min(7, n);
            for (int i = 0; i < days; i++) res += start + i;
            start++;
            n -= days;
        }
        return res;
    }
}
