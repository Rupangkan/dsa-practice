class Solution {
    public long maximumHappinessSum(int[] h, int k) {
        Arrays.sort(h);
        int n = h.length-1;
        int ded = 0;
        long sum = 0;
        for(int i = k-1; i>=0 && n>=0; i--, n--) {
            if(h[n]-ded >= 0) {
                sum = (sum + h[n]) - ded;
                ded++; 
            } else {
                break;
            }
        }
        return sum;
    }
}