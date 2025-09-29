class Solution{
    int n;
    int[]v;
    Map<Integer,Integer>m=new HashMap<>();

    int f(int i,int j){
        if(i+2>j)return 0;
        if(i+2==j)return v[i]*v[i+1]*v[j];
        int k=i*n+j;
        if(!m.containsKey(k)){
            int ans=Integer.MAX_VALUE;
            for(int x=i+1;x<j;x++)
                ans=Math.min(ans,v[i]*v[x]*v[j]+f(i,x)+f(x,j));
            m.put(k,ans);
        }
        return m.get(k);
    }

    public int minScoreTriangulation(int[] a){
        n=a.length;
        v=a;
        return f(0,n-1);
    }
}
