class Solution {
    // On2
    private int brute(int[] nums) {return -1;}


    // Onlogn + ON
    private int better(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        if(n == 0) return 0;

        int lastSmaller = Integer.MIN_VALUE;
        int longest = 1, currCount = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] - 1 == lastSmaller) {
                currCount++;
                lastSmaller = nums[i];
            } else if(nums[i] != lastSmaller) {
                currCount = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, currCount);
        }
        return longest;
    }

    private int optimal(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int currCount = 0, longest = 0;
        for(int i = 0; i<n; i++) {
            set.add(nums[i]);
        }

        for(int i: set) {
            if(!set.contains(i-1)) {
                int curr = i;
                currCount = 1;

                while(set.contains(curr + 1)) {
                    curr++;
                    currCount++;
                }
            }
            longest = Math.max(longest, currCount);
        }
        return longest;
    }

    public int longestConsecutive(int[] nums) {
        // return better(nums);
        return optimal(nums);
    }
}