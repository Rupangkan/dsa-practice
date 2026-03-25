class Solution{
    public boolean canPartitionGrid(int[][] g){
        int m=g.length,n=g[0].length;
        long s=0;

        for(int[] r:g)
            for(int x:r) s+=x;

        if((s&1)==1) return false;

        long t=s>>1,cur=0;

        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++) cur+=g[i][j];
            if(cur==t) return true;
        }

        cur=0;
        for(int j=0;j<n-1;j++){
            for(int i=0;i<m;i++) cur+=g[i][j];
            if(cur==t) return true;
        }
        return false;
    }
}