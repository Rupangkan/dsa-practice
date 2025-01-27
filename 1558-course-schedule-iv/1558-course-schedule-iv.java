class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] q) {
        boolean[][] isP = new boolean[n][n];

        for(int[] p: pre) {
            isP[p[0]][p[1]] = true;
        }

        for(int k = 0; k<n; k++) {
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    isP[i][j] |= isP[i][k] && isP[k][j];
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] que: q) ans.add(isP[que[0]][que[1]]);
        return ans;
    }
}
