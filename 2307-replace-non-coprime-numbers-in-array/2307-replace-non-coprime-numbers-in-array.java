class Solution {
    
    private int gcd(int x,int y){
        return y==0?x:gcd(y,x%y);
    }

    public List<Integer> replaceNonCoprimes(int[] a) {
        List<Integer> st=new ArrayList<>();
        for(int x:a){
            while(!st.isEmpty()){
                int y=st.get(st.size()-1);
                int g=gcd(y,x);
                if(g==1) break;
                st.remove(st.size()-1);
                x=(y/g)*x;
            }
            st.add(x);
        }
        return st;
    }
}
