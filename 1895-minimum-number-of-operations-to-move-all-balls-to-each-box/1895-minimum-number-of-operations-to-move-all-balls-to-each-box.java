class Solution {
    public int[] minOperations(String b) {
        int n = b.length();
        int[] ans = new int[n];

        int ballsLeft = 0, movesLeft = 0, ballsRight = 0, movesRight = 0;

        for(int i = 0; i<n; i++) {
            ans[i] += movesLeft;
            ballsLeft += Character.getNumericValue(b.charAt(i));
            movesLeft += ballsLeft;
            int j = n-1-i;
            ans[j] += movesRight;
            ballsRight += Character.getNumericValue(b.charAt(j));
            movesRight += ballsRight;
        }

        return ans;
    }
}