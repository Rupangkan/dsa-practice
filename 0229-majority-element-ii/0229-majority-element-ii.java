class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int n = nums.length;
        int count1 = 0, count2 = 0;

        for(int i = 0; i<n; i++) {
            int curr = nums[i];
            if(count1 == 0 && curr != ele2) {
                ele1 = curr;
                count1++;
            } else if(count2 == 0 && curr != ele1) {
                ele2 = curr;
                count2++;
            } else if(curr == ele1) count1++;
            else if (curr == ele2) count2++;
            else {
                count1--;
                count2--;
            }
        }

        int c1 = 0, c2 = 0;
        for(int i = 0; i<n; i++) {
            if(ele1 == nums[i]) c1++;
            else if(ele2 == nums[i]) c2++;
        }

        List<Integer> ans = new ArrayList<>();
        if(c1 > n/3) ans.add(ele1);
        if(c2 > n/3) ans.add(ele2);

        return ans;
    }
}