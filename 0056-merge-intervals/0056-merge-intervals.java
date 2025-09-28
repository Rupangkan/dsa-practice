class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i<n; i++) {
            int start = nums[i][0];
            int end = nums[i][1];
            if(ans.isEmpty() || ans.get(ans.size()-1)[1] < start) {
                ans.add(new int[] {start, end});
            } else {
                end = Math.max(end, ans.get(ans.size()-1)[1]);
                ans.get(ans.size()-1)[1] = end;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}