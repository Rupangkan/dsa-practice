class Solution {
    
    private void swap(int[] nums, int one, int two) {
        int t = nums[one];
        nums[one] = nums[two];
        nums[two] = t;   
        System.out.println(nums);
        System.out.println(one + " " + two);
    }

    private void reverse(int[] nums, int idx) {
        int n = nums.length - 1;
        while(idx<n) {
            swap(nums, idx, n);
            idx++;
            n--;
        }
    }

    private void optimal(int[] nums) {
        int n = nums.length, index = -1;

        for(int i = n-1; i>0; i--) {
            if(nums[i-1] < nums[i]) {
                // swap(nums, i, i-1);
                index = i-1;
                break;
            }
        }
        if(index == -1) reverse(nums, 0);
        else {
            for(int i = n-1; i>0; i--) {
                if(nums[i] > nums[index]) {
                    swap(nums, index, i);
                    break;
                }
            }
            reverse(nums, index + 1);
        }
    }

    public void nextPermutation(int[] nums) {
        optimal(nums);
    }
}