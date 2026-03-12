class DSU{
    int[] p;
    DSU(int[] a){ p=a.clone(); }
    int f(int x){ return p[x]==x?x:(p[x]=f(p[x])); }
    void u(int a,int b){ p[f(a)]=f(b); }
}

class Solution{
    static final int INF=200000;

    public int maxStability(int n,int[][] e,int k){
        if(e.length<n-1) return -1;

        List<int[]> must=new ArrayList<>(),opt=new ArrayList<>();
        for(int[] x:e) if(x[3]==1) must.add(x); else opt.add(x);
        if(must.size()>n-1) return -1;

        opt.sort((a,b)->b[2]-a[2]);

        int[] p=new int[n];
        for(int i=0;i<n;i++) p[i]=i;
        DSU d0=new DSU(p);

        int sel=0,lim=INF;
        for(int[] x:must){
            int u=x[0],v=x[1],s=x[2];
            if(d0.f(u)==d0.f(v)||sel==n-1) return -1;
            d0.u(u,v);
            sel++;
            lim=Math.min(lim,s);
        }

        int l=0,r=lim,ans=-1;
        while(l<r){
            int mid=l+(r-l+1)/2;
            DSU d=new DSU(d0.p);
            int take=sel,use=0;

            for(int[] x:opt){
                int u=x[0],v=x[1],s=x[2];
                if(d.f(u)==d.f(v)) continue;
                if(s>=mid){ d.u(u,v); take++; }
                else if(use<k&&s*2>=mid){ use++; d.u(u,v); take++; }
                else break;
                if(take==n-1) break;
            }

            if(take!=n-1) r=mid-1;
            else ans=l=mid;
        }
        return ans;
    }
}