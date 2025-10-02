class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++) {
            if(count1 == 0 && ele2 != nums[i]) {
                ele1 = nums[i];
                count1 = 1;
            } else if(count2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                count2 = 1;
            } else if(nums[i] == ele1) count1++;
            else if(nums[i] == ele2) count2++;
            else {
                count1--;
                count2--;
            }
        }

        List<Integer> arr = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] == ele1) cnt1++;
            if(nums[i] == ele2) cnt2++;
        }

        if(cnt1 > n/3) arr.add(ele1);
        if(cnt2 > n/3) arr.add(ele2);
        return arr;
    }
}