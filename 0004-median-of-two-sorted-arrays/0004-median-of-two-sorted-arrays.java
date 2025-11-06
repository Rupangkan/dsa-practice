class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1, 2, 3, 4, 5, 7, 8, 9
        // 3, 4, 5, 6, 7
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int n = (n1 + n2);

        int low = 0, high = n1;

        while(low <= high) {
            int c1 = (low + high) >> 1;
            int c2 = (n1 + n2 + 1)/2 - c1;

            int l1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[c1-1];
            int l2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[c2-1];
            int r1 = (c1 >= n1) ? Integer.MAX_VALUE : nums1[c1];
            int r2 = (c2 >= n2) ? Integer.MAX_VALUE : nums2[c2];

            if(l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    int a = Math.max(l1, l2);
                    int b = Math.min(r1, r2);
                    return (double) ((a+b)/2.0);
                } else {
                    return (double) Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = c1 - 1;
            } else {
                low = c1 + 1;
            }
        }

        return -1;
    }
}