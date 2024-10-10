class Solution {

    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int currIdx = 0;
        int[] nonInc = new int[n];
        int[] nonDec = new int[n];
        List<Integer> ans = new ArrayList<>();

        int count = 1;
        nonInc[0] = 1;

        for(int i = 1; i<n; i++) {
            if(nums[i] <= nums[i-1]) {
                count++;
                nonInc[i] = count;
            } else {
                count = 1;
                nonInc[i] = count;
            }
        }

        count = 1;
        nonDec[n-1] = 1;

        for(int i = n-2; i>=0; i--) {
            if(nums[i] <= nums[i+1]) {
                count++;
                nonDec[i] = count;
            } else {
                count = 1;
                nonDec[i] = count;
            }
        }

        System.out.println(Arrays.toString(nonInc));
        System.out.println(Arrays.toString(nonDec));

        for(int i = k; i<n-k; i++) {
            if(nonInc[i-1] >= k && nonDec[i+1] >= k) {
                ans.add(i);
            }    
        }
        return ans;
    }
}