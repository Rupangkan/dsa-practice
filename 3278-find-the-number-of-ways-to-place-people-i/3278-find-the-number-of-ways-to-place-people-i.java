public class Solution {
    public int numberOfPairs(int[][] p) {
        int n=p.length,res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j||p[i][0]>p[j][0]||p[i][1]<p[j][1]) continue;
                if(n==2){res++;continue;}
                boolean bad=false;
                for(int k=0;k<n;k++){
                    if(k==i||k==j) continue;
                    if(p[k][0]>=p[i][0]&&p[k][0]<=p[j][0]&&p[k][1]<=p[i][1]&&p[k][1]>=p[j][1]){
                        bad=true;break;
                    }
                }
                if(!bad) res++;
            }
        }
        return res;
    }
}
