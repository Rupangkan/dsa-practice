class Solution {
    private void better(int[] nums) {
         int zeroC = 0, oneC = 0, twoC = 0, n = nums.length;

        for(int i = 0; i<n; i++) {
            if(nums[i] == 0) zeroC++;
            else if(nums[i] == 1) oneC++;
            else twoC++;
        }

        int idx = 0;
        while(zeroC > 0) {
            nums[idx] = 0;
            zeroC--;
            idx++;
        }
        while(oneC > 0) {
            nums[idx] = 1;
            oneC--;
            idx++;
        }
        while(twoC > 0) {
            nums[idx] = 2;
            twoC--;
            idx++;
        }
    }
        
    private void swap(int[] nums, int one, int two) {
        int t = nums[one];
        nums[one] = nums[two];
        nums[two] = t;   
    }

    private void optimal(int[] nums) {
        int n = nums.length;
        int high = nums.length - 1, mid = 0, low = 0;

        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if(nums[mid] == 1) mid++;
            else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void sortColors(int[] nums) {
        optimal(nums);
    }
}