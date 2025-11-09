class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int low = 0, high = n - 1;
        int leftMax = 0, rightMax = 0;
        int count = 0;

        while(low < high) {
            if(h[low] <= h[high]) {
                if(leftMax > h[low]) {
                    count += leftMax - h[low];
                } else {
                    leftMax = h[low];
                }
                low++;
            } else {
                if(rightMax > h[high]) {
                    count += rightMax - h[high];
                } else {
                    rightMax = h[high];
                }
                high--;
            }
        }

        return count;
    }
}