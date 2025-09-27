class Solution {
    public double largestTriangleArea(int[][] p){
        double ans=0;
        for(int i=0;i<p.length;i++)
            for(int j=i+1;j<p.length;j++)
                for(int k=j+1;k<p.length;k++)
                    ans=Math.max(ans,0.5*Math.abs(
                        p[i][0]*p[j][1]+p[j][0]*p[k][1]+p[k][0]*p[i][1]
                       -p[i][1]*p[j][0]-p[j][1]*p[k][0]-p[k][1]*p[i][0]));
        return ans;
    }
}