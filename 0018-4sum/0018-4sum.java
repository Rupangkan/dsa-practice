class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<n; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = n-1;
                while(left < right) {
                    List<Integer> temp = new ArrayList<>();
                    long sum = nums[i];
                    sum += (long) nums[j];
                    sum += (long) nums[left];
                    sum += (long) nums[right];

                    if(sum == (long)target) {
                        // add to arrayList
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        ans.add(temp);
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(right > left && right<n-1 && nums[right] == nums[right+1]) right--;
                    } else if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
        
    }
}