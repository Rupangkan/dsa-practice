class Router {
    int sz;
    Map<Integer,List<Integer>> cnt;
    Map<Long,int[]> pk;
    Queue<Long> q;

    public Router(int m){
        sz=m;
        pk=new HashMap<>();
        cnt=new HashMap<>();
        q=new LinkedList<>();
    }

    public boolean addPacket(int s,int d,int t){
        long k=enc(s,d,t);
        if(pk.containsKey(k)) return false;
        if(pk.size()>=sz) forwardPacket();
        pk.put(k,new int[]{s,d,t});
        q.offer(k);
        cnt.putIfAbsent(d,new ArrayList<>());
        cnt.get(d).add(t);
        return true;
    }

    public int[] forwardPacket(){
        if(pk.isEmpty()) return new int[]{};
        long k=q.poll();
        int[]p=pk.remove(k);
        if(p==null) return new int[]{};
        int d=p[1];
        cnt.get(d).remove(0);
        return p;
    }

    public int getCount(int d,int l,int r){
        List<Integer>x=cnt.get(d);
        if(x==null||x.isEmpty()) return 0;
        return ub(x,r)-lb(x,l);
    }

    private long enc(int s,int d,int t){
        return ((long)s<<40)|((long)d<<20)|t;
    }

    private int lb(List<Integer>a,int t){
        int l=0,h=a.size();
        while(l<h){
            int m=(l+h)>>>1;
            if(a.get(m)<t) l=m+1; else h=m;
        }
        return l;
    }

    private int ub(List<Integer>a,int t){
        int l=0,h=a.size();
        while(l<h){
            int m=(l+h)>>>1;
            if(a.get(m)<=t) l=m+1; else h=m;
        }
        return l;
    }
}
