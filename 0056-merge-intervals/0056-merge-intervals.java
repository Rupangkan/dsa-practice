class Solution {
    public int[][] merge(int[][] in) {
        int n = in.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(in, (a, b) -> a[0] - b[0]);

        for(int i = 0; i<n; i++) {
            if(ans.size() == 0 || ans.get(ans.size()-1)[1] < in[i][0]) {
                ans.add(new int[] {in[i][0], in[i][1]});
            } else {
                int max = ans.get(ans.size()-1)[1];
                max = Math.max(max, in[i][1]);
                ans.get(ans.size()-1)[1] = max;
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}