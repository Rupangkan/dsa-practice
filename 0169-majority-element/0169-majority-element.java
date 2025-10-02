class Solution {
    private int brute(int[] nums) {
        int n = nums.length;

        for(int i = 0; i<n; i++) {
            int currCount = 0;
            int curr = nums[i];
            for(int j = i; j<n; j++) {
                if(curr == nums[j]) currCount++;
            }
            if(currCount > n/2) return curr;
        }
        return -1;
    }

    // O (nlogn) + O (N)
    public int better(int[] nums) {
        // use hashmap and store the values and count;
        return -1;
    }

    // Moore's voting algorithm, LEARN THE INTUITION
    private int optimal(int[] nums) {
        int n = nums.length;
        int curr = 0;
        int count = 0;

        for(int i = 0; i<n; i++) {
            if(count == 0) {
                curr = nums[i];
                count = 1;
            } else if(nums[i] == curr) {
                count++;
            } else {
                count--;
            }
        }

        return curr;
    }

    public int majorityElement(int[] nums) {
        return brute(nums);
    }
}