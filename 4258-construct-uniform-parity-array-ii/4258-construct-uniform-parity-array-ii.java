class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        boolean odd = false;

        for (int x : nums1) {
            min = Math.min(min, x);
            odd |= (x & 1) == 1;
        }

        return (min & 1) == 1 || !odd;
    }
}