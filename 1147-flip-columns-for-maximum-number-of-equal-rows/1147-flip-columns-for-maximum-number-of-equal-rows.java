class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> pf = new HashMap<>();

        for(int[] row: matrix) {
            StringBuilder s = new StringBuilder("");
            for(int col = 0; col < row.length; col++) {
                if(row[0] == row[col]) {
                    s.append("T");
                } else {
                    s.append("F");
                }
            }
            String rp = s.toString();
            pf.put(rp, pf.getOrDefault(rp, 0) + 1);
        } 

        int ans = 0;
        for(int freq: pf.values()) {
            ans = Math.max(ans, freq);
        }
        return ans;
    }
}