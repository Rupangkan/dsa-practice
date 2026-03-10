class Solution{
    public int numberOfStableArrays(int z,int o,int l){
        int M=1_000_000_007,dp[][][]=new int[z+1][o+1][2];
        for(int i=0;i<=z;i++)for(int j=0;j<=o;j++)for(int b=0;b<2;b++){
            if(i==0) dp[i][j][b]=(b==0||j>l)?0:1;
            else if(j==0) dp[i][j][b]=(b==1||i>l)?0:1;
            else if(b==0){
                dp[i][j][b]=dp[i-1][j][0]+dp[i-1][j][1];
                if(i>l) dp[i][j][b]-=dp[i-l-1][j][1];
            }else{
                dp[i][j][b]=dp[i][j-1][0]+dp[i][j-1][1];
                if(j>l) dp[i][j][b]-=dp[i][j-l-1][0];
            }
            dp[i][j][b]%=M;
            if(dp[i][j][b]<0) dp[i][j][b]+=M;
        }
        return (dp[z][o][0]+dp[z][o][1])%M;
    }
}