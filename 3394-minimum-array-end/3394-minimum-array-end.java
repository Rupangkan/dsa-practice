class Solution {

    boolean power2(long curr) {
        if(curr == 1) return false;
        return (curr&(curr-1)) == 0;
    }

    boolean allSetBits(long curr) {
        return (curr&(curr+1)) == 0;
    }

    public long minEnd(int n, int x) {
        long curr = x;
        int l = 0;

        while(l++ < n-1) {
            curr = (curr + 1) | x;
        }
        return curr;
         
    }
}