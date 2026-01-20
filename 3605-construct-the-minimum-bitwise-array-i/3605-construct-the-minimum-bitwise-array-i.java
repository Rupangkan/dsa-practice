class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i<n; i++) {
            boolean flag = false;
            int startInd = nums.get(i)/2;
            for(int j = startInd; j<=nums.get(i)-1; j++) {
                if((j | j + 1) == nums.get(i)) {
                    flag = true;
                    ans[i] = j;
                    break;
                }
            }
            if(flag == false) ans[i] = -1;
        }

        return ans;
    }
}