class Solution {
    int[][] dirs = {{1,1},{1,-1},{-1,-1},{-1,1}};
    int[][][][] dp;
    int[][] g;
    int n,m;

    public int lenOfVDiagonal(int[][] a) {
        g=a; n=a.length; m=a[0].length;
        dp=new int[n][m][4][2];
        for(int i=0;i<n;i++)for(int j=0;j<m;j++)for(int k=0;k<4;k++)Arrays.fill(dp[i][j][k],-1);
        int ans=0;
        for(int i=0;i<n;i++)for(int j=0;j<m;j++)if(a[i][j]==1)
            for(int d=0;d<4;d++) ans=Math.max(ans,go(i,j,d,1,2)+1);
        return ans;
    }

    int go(int x,int y,int d,int t,int val){
        int nx=x+dirs[d][0], ny=y+dirs[d][1];
        if(nx<0||ny<0||nx>=n||ny>=m||g[nx][ny]!=val) return 0;
        if(dp[nx][ny][d][t]!=-1) return dp[nx][ny][d][t];
        int res=go(nx,ny,d,t,2-val);
        if(t==1) res=Math.max(res,go(nx,ny,(d+1)%4,0,2-val));
        return dp[nx][ny][d][t]=res+1;
    }
}