class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1, max = Integer.MIN_VALUE;

        while(l<r) {
            int currArea = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(currArea, max);

            if(height[l]<height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}