class Solution {
    public int[][] merge(int[][] in) {
        Arrays.sort(in, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();

        for(int i = 0; i<in.length; i++) {
            int start = in[i][0];
            int end = in[i][1];
            if(ans.isEmpty() || ans.get(ans.size()-1)[1] < start) {
                ans.add(new int[] {start, end});
            } else {
                end = Math.max(ans.get(ans.size()-1)[1], end);
                ans.get(ans.size()-1)[1] = end;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}