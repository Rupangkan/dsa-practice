class Solution {

    private void swap(int[] nums1, int[] nums2, int nInd, int mInd) {
        int t = nums1[nInd];
        nums1[nInd] = nums2[mInd];
        nums2[mInd] = t;
    }

    // O(n+m) + Onlogn + Onlogn Optimal but not for this solution, 
    // This leetcode solution need nums1 to have all the numbers

    private void optimal(int[] nums1, int m, int[] nums2, int n) {
        int nInd = n-1, mInd = 0;

        while(nInd >= 0 && mInd < m) {
            if(nums1[nInd] > nums2[mInd]) {
                swap(nums1, nums2, nInd, mInd);
                nInd--;
                mInd++;
            } else {
                break;
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = 0;
        for(int i = m+n-1; i>=m; i--, count++) {
            nums1[i] = nums2[count]; 
        }
        Arrays.sort(nums1);
    }
}