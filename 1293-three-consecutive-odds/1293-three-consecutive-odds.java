class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int l = 0, r = 0, n = arr.length, count = 0;

        while(r<n) {
            if(l<=r && arr[r] % 2 == 1) {
                count++;
            } else {
                count = 0;
            }
            if(count >= 3) return true;
            r++;
        }
        if(count >= 3) return true;
        else return false;
    }
}