class Solution {
    public int numberOfPairs(int[][] a) {
        Arrays.sort(a,(u,v)->u[0]==v[0]?u[1]-v[1]:v[0]-u[0]);
        int n=a.length,res=0;
        for(int i=0;i<n-1;i++){
            int mn=Integer.MAX_VALUE,yi=a[i][1];
            for(int j=i+1;j<n;j++){
                int yj=a[j][1];
                if(yj>=yi&&yj<mn){
                    res++;
                    mn=yj;
                    if(yi==yj) break;
                }
            }
        }
        return res;
    }
}
