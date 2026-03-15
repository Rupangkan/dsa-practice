class Fancy{
    static final int M=1_000_000_007;
    List<Integer> v=new ArrayList<>(),a=new ArrayList<>(),b=new ArrayList<>();

    public Fancy(){
        a.add(1);
        b.add(0);
    }

    public void append(int x){
        v.add(x);
        a.add(a.get(a.size()-1));
        b.add(b.get(b.size()-1));
    }

    public void addAll(int x){
        int i=b.size()-1;
        b.set(i,(b.get(i)+x)%M);
    }

    public void multAll(int m){
        int i=a.size()-1;
        a.set(i,(int)((long)a.get(i)*m%M));
        b.set(i,(int)((long)b.get(i)*m%M));
    }

    public int getIndex(int i){
        if(i>=v.size()) return -1;
        int ao=(int)((long)inv(a.get(i))*a.get(a.size()-1)%M);
        int bo=(int)(((long)b.get(b.size()-1)-((long)b.get(i)*ao)%M+M)%M);
        return (int)(((long)ao*v.get(i)+bo)%M);
    }

    int pow(int x,int y){
        long r=1,c=x;
        while(y>0){
            if((y&1)==1) r=r*c%M;
            c=c*c%M;
            y>>=1;
        }
        return (int)r;
    }

    int inv(int x){
        return pow(x,M-2);
    }
}