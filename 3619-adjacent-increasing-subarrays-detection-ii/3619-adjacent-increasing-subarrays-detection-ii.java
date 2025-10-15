class Solution {
    boolean check(List<Integer> nums, int mid, int[] prefix) {
        int n = nums.size();
        for(int i = 0; i<=n-2*mid; i++) {
            if(prefix[i] >= mid && prefix[i+mid] >= mid) return true;
        }
        return false;
    } 
    
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int[] prefix = new int[n];
        prefix[n-1] = 1;
        for(int i = n-2; i>=0; i--) {
            if(nums.get(i+1) > nums.get(i)) prefix[i] = prefix[i+1]+1;
            else prefix[i] = 1;
        }

        int l = 0, r = n/2;

        while(l<=r) {
            int mid = l+(r-l)/2;
            if(check(nums, mid, prefix)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }
}