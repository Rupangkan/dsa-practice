class Solution {
    public int numberOfArrays(int[] diff, int lower, int upper) {
        int a = 0, b = 0, ans = 0; 
        for(int i: diff) {
            ans += i;
            a = Math.min(a, ans);
            b = Math.max(b, ans);
            if(b - a > upper - lower) return 0;
        }
        return (upper - lower) - (b - a) + 1;
    }
}