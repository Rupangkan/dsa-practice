class Solution {
    public int longestConsecutive(int[] nums) {
        // 1, 2, 3, 4, 100, 200
        int n = nums.length;
        Set<Integer> st = new HashSet<>();

        for(int i = 0; i<n; i++) {
            st.add(nums[i]);
        }

        int currCount = 0, longest = 0;

        for(int i: st) {
            if(!st.contains(i-1)) {
                int curr = i;
                currCount = 1;

                while(st.contains(curr+1)) {
                    curr++;
                    currCount++;
                }
            }
            longest = Math.max(longest, currCount);
        }
        return longest;
    }
}