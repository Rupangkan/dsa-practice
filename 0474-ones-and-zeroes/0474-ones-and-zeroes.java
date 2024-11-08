class Solution {
    int solve(int idx, String[] strs, int z, int o, int[][][] dp) {
        if(idx >= strs.length) return 0;
        if(dp[idx][z][o] != -1) return dp[idx][z][o];

        int notPick = solve(idx+1, strs, z, o, dp);
        int pick = 0, zeroCount = 0, oneCount = 0;
        for(int i = 0; i<strs[idx].length(); i++) {
            char curr = strs[idx].charAt(i);
            if(curr == '1') oneCount++;
            else zeroCount++;
        }
        if(zeroCount <= z && oneCount <= o) {
            pick = 1+solve(idx+1, strs, z-zeroCount, o-oneCount, dp);
        }
        return dp[idx][z][o] = Math.max(pick, notPick);
        // return Math.max(pick, notPick);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m+1][n+1];
        for(int[][] arr: dp){
            for(int[] arr1: arr) Arrays.fill(arr1, -1);
        }
        return solve(0, strs, m, n, dp);
    
    }
}