class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nArr = new ArrayList<>();
        int ans = 0, n = grid.length;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] % x != grid[0][0] % x) return -1;
                nArr.add(grid[i][j]);
            }
        }

        Collections.sort(nArr);

        int len = nArr.size(), pInd = 0, sInd = len - 1;

        while(pInd < sInd) {
            if(pInd < len - sInd - 1) {
                int ops = ((pInd + 1) * (nArr.get(pInd + 1) - nArr.get(pInd))) / x;
                ans += ops;
                pInd++;
            } else {
                int ops = ((len - sInd) * (nArr.get(sInd) - nArr.get(sInd - 1))) / x;
                ans += ops;
                sInd--;
            }
        }

        return ans;
    }
}