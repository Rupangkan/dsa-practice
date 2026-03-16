class Answer{
    int[] a=new int[3];
    void put(int x){
        if(x>a[0]){
            a[2]=a[1];
            a[1]=a[0];
            a[0]=x;
        }else if(x!=a[0]&&x>a[1]){
            a[2]=a[1];
            a[1]=x;
        }else if(x!=a[0]&&x!=a[1]&&x>a[2]){
            a[2]=x;
        }
    }
    List<Integer> get(){
        List<Integer> r=new ArrayList<>();
        for(int x:a) if(x!=0) r.add(x);
        return r;
    }
}

class Solution{
    public int[] getBiggestThree(int[][] g){
        int m=g.length,n=g[0].length;
        int[][] s1=new int[m+1][n+2],s2=new int[m+1][n+2];

        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                s1[i][j]=s1[i-1][j-1]+g[i-1][j-1];
                s2[i][j]=s2[i-1][j+1]+g[i-1][j-1];
            }

        Answer ans=new Answer();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans.put(g[i][j]);
                for(int k=i+2;k<m;k+=2){
                    int ux=i,uy=j,dx=k,dy=j;
                    int lx=(i+k)/2,ly=j-(k-i)/2;
                    int rx=(i+k)/2,ry=j+(k-i)/2;
                    if(ly<0||ry>=n) break;

                    int sum=
                        (s2[lx+1][ly+1]-s2[ux][uy+2])+
                        (s1[rx+1][ry+1]-s1[ux][uy])+
                        (s1[dx+1][dy+1]-s1[lx][ly])+
                        (s2[dx+1][dy+1]-s2[rx][ry+2])-
                        (g[ux][uy]+g[dx][dy]+g[lx][ly]+g[rx][ry]);

                    ans.put(sum);
                }
            }
        }

        List<Integer> l=ans.get();
        int[] r=new int[l.size()];
        for(int i=0;i<l.size();i++) r[i]=l.get(i);
        return r;
    }
}