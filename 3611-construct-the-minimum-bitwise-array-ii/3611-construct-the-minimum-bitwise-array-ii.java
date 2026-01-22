class Solution {
    public boolean isAllOnes(int n) {
        return n > 0 && (n & (n + 1)) == 0;
    }
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i<n; i++) {
            if(nums.get(i) < 3) {
                ans[i] = -1;
            } else {
                int x = nums.get(i);
                if((x & (x+1)) == 0) {
                    ans[i] = x >> 1;
                    continue;
                }

                int lastBit = 0;
                boolean flag = true;
                int y = x;

                while(y != 0) {
                    int bit = y % 2;
                    if(bit == 1) {
                        lastBit++;
                        flag = false;
                    } else {
                        break;
                    }
                    y = y>>1;
                }

                if(flag) {
                    ans[i] = -1;
                } else {
                    lastBit--;
                    int mask = 1 << lastBit;
                    int temp = x & (~mask);
                    ans[i] = temp;
                }
            }
        }
        return ans;
        
    }
}