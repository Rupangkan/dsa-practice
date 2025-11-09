class Solution {
    public int countOperations(int a, int b) {
        int ans = 0;
        while(a != 0 && b != 0){
            ans += a / b;
            a %= b;
            int t = a; 
            a = b; 
            b = t;
        }
        return ans;
    }
}
