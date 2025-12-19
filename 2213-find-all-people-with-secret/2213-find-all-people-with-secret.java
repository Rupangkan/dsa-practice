class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a,b)->a[2]-b[2]);
        DSU dsu = new DSU(n);
        dsu.u(0, firstPerson);

        for (int i = 0; i < meetings.length; ) {
            int t = meetings[i][2];
            List<int[]> cur = new ArrayList<>();
            while (i < meetings.length && meetings[i][2] == t) {
                cur.add(meetings[i++]);
            }
            for (int[] e : cur) dsu.u(e[0], e[1]);
            for (int[] e : cur) {
                if (!dsu.c(e[0], 0)) {
                    dsu.r(e[0]);
                    dsu.r(e[1]);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) if (dsu.c(i, 0)) ans.add(i);
        return ans;
    }
}

class DSU {
    int[] p, r;
    DSU(int n){
        p = new int[n];
        r = new int[n];
        for(int i=0;i<n;i++) p[i]=i;
    }
    int f(int x){
        if(p[x]!=x) p[x]=f(p[x]);
        return p[x];
    }
    void u(int a,int b){
        a=f(a); b=f(b);
        if(a==b) return;
        if(r[a]<r[b]) p[a]=b;
        else if(r[a]>r[b]) p[b]=a;
        else{ p[b]=a; r[a]++; }
    }
    boolean c(int a,int b){ return f(a)==f(b); }
    void r(int x){ p[x]=x; r[x]=0; }
}
