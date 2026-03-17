class Solution{
    public int largestSubmatrix(int[][] a){
        int m=a.length,n=a[0].length,ans=0;
        int[] h=new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                h[j]=a[i][j]==0?0:h[j]+1;

            int[] b=h.clone();
            Arrays.sort(b);

            for(int i2=0;i2<n;i2++)
                ans=Math.max(ans,b[i2]*(n-i2));
        }
        return ans;
    }
}