class Solution {
    boolean solve(int[] nums, int start, int d) {
        int n = nums.length;
        int[] copy = nums.clone();
        int curr = start;

        while(curr >= 0 && curr < n) {
            if(copy[curr] == 0) {
                curr += d;
            } else if(copy[curr] > 0) {
                copy[curr]--;
                d = -d;
                curr += d;
            }
        } 

        for(int num: copy) {
            if(num != 0) return false; 
        }
        return true;
    }
    
    public int countValidSelections(int[] nums) {
        int n = nums.length, count = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] == 0) {
                if(solve(nums, i, 1)) {
                    count++;
                }
                if(solve(nums, i, -1)) {
                    count++;
                }
            }
        }
        return count;
    }
}