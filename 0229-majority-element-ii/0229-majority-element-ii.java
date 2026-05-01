class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        for(int i = 0; i<n; i++) {
            if(count1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                count1++;
            } else if(count2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                count2++;
            } else if(nums[i] == ele2) {
                count2++;
            } else if(nums[i] == ele1) {
                count1++;
            } else {
                count1--;
                count2--;
            }
        }

        int c1 = 0, c2 = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] == ele1) c1++;
            else if(nums[i] == ele2) c2++;
        }

        List<Integer> ans = new ArrayList<>();
        if(c1 > n/3) ans.add(ele1);
        if(c2 > n/3) ans.add(ele2);

        return ans;
    }
}