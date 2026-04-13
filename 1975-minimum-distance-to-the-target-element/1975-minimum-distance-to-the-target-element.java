class Solution {

    public int getMinDistance(int[] nums, int target, int start) {
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int d = i - start;
                if (d < 0) d = -d;
                ans = Math.min(ans, d);
            }
        }

        return ans;
    }
}