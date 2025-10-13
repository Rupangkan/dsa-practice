class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int ele1 = 0, ele2 = 0, c1 = 0, c2 = 0;

        for(int i = 0; i<n; i++) {
            if(c1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                c1++;
            } else if(c2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                c2++;
            } else if(ele1 == nums[i]) c1++;
            else if(ele2 == nums[i]) c2++;
            else if(ele1 != nums[i] && ele2 != nums[i]) {
                c1--;
                c2--;
            }
        }

        int count1 = 0, count2 = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] == ele1) count1++;
            else if(nums[i] == ele2) count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(count1 > n/3) ans.add(ele1);
        if(count2 > n/3) ans.add(ele2);
        return ans;
    }
}