class MovieRentingSystem {
    class E{
        int s,m,p;
        E(int s,int m,int p){this.s=s;this.m=m;this.p=p;}
        public boolean equals(Object o){
            if(this==o)return true;
            if(o==null||getClass()!=o.getClass())return false;
            E e=(E)o;return s==e.s&&m==e.m;
        }
        public int hashCode(){return Objects.hash(s,m);}
    }
    Map<Integer,TreeSet<E>> mp;
    Map<E,Integer> mp2;
    TreeSet<E> st;

    public MovieRentingSystem(int n,int[][] es){
        mp=new TreeMap<>();
        mp2=new HashMap<>();
        st=new TreeSet<>((a,b)->a.p!=b.p?a.p-b.p:a.s!=b.s?a.s-b.s:a.m-b.m);
        for(int[]x:es){
            int s=x[0],m=x[1],p=x[2];
            E e=new E(s,m,p);
            mp.putIfAbsent(m,new TreeSet<>((a,b)->a.p!=b.p?a.p-b.p:a.s-b.s));
            mp2.put(e,p);
            mp.get(m).add(e);
        }
    }

    public List<Integer> search(int m){
        List<Integer>res=new ArrayList<>();
        if(!mp.containsKey(m))return res;
        for(E e:mp.get(m)){
            res.add(e.s);
            if(res.size()==5)break;
        }
        return res;
    }

    public void rent(int s,int m){
        int p=mp2.get(new E(s,m,0));
        E e=new E(s,m,p);
        mp.get(m).remove(e);
        st.add(e);
    }

    public void drop(int s,int m){
        int p=mp2.get(new E(s,m,0));
        E e=new E(s,m,p);
        mp.get(m).add(e);
        st.remove(e);
    }

    public List<List<Integer>> report(){
        List<List<Integer>>res=new ArrayList<>();
        for(E e:st){
            res.add(Arrays.asList(e.s,e.m));
            if(res.size()==5)break;
        }
        return res;
    }
}
