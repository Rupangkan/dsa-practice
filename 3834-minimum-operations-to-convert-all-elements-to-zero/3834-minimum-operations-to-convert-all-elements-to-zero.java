class Solution {
    public int minOperations(int[] a) {
        int n = a.length, ans = 0;
        int[] st = new int[n];
        int top = 0;
        for(int x : a){
            while(top > 0 && st[top-1] > x) top--;
            if(x == 0) continue;
            if(top == 0 || st[top-1] < x){
                st[top++] = x;
                ans++;
            }
        }
        return ans;
    }
}
