class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), res = 0;
        int[] pre = new int[n+1];
        pre[0] = -1;
        for(int i=0;i<n;i++){
            if(i==0 || s.charAt(i-1)=='0') pre[i+1] = i;
            else pre[i+1] = pre[i];
        }
        for(int i=1;i<=n;i++){
            int c0 = s.charAt(i-1)=='0'?1:0, j = i;
            while(j>0 && c0*c0<=n){
                int c1 = (i - pre[j]) - c0;
                if(c0*c0 <= c1){
                    res += Math.min(j - pre[j], c1 - c0*c0 + 1);
                }
                j = pre[j];
                c0++;
            }
        }
        return res;
    }
}
