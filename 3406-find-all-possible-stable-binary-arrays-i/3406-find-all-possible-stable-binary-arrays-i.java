class Solution{
    public int numberOfStableArrays(int z,int o,int l){
        long M=1_000_000_007,dp[][][]=new long[z+1][o+1][2];
        for(int i=0;i<=Math.min(z,l);i++) dp[i][0][0]=1;
        for(int j=0;j<=Math.min(o,l);j++) dp[0][j][1]=1;
        for(int i=1;i<=z;i++) for(int j=1;j<=o;j++){
            dp[i][j][0]=i>l?dp[i-1][j][0]+dp[i-1][j][1]-dp[i-l-1][j][1]:dp[i-1][j][0]+dp[i-1][j][1];
            dp[i][j][0]=(dp[i][j][0]%M+M)%M;
            dp[i][j][1]=j>l?dp[i][j-1][1]+dp[i][j-1][0]-dp[i][j-l-1][0]:dp[i][j-1][1]+dp[i][j-1][0];
            dp[i][j][1]=(dp[i][j][1]%M+M)%M;
        }
        return (int)((dp[z][o][0]+dp[z][o][1])%M);
    }
}