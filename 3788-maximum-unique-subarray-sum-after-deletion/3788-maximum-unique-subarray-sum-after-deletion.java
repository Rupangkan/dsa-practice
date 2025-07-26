class Solution {
    public int maxSum(int[] a) {
        boolean[] seen = new boolean[100001];
        int sum = 0, max = Integer.MIN_VALUE;
        for (int x : a) {
            max = Math.max(max, x);
            if (x > 0 && !seen[x]) {
                seen[x] = true;
                sum += x;
            }
        }
        return sum == 0 ? max : sum;
    }
}