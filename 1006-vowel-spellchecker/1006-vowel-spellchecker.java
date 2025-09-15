class Solution {
    Set<String> exact;
    Map<String,String> cap,vow;
    
    public String[] spellchecker(String[] wl,String[] qs){
        exact=new HashSet<>();
        cap=new HashMap<>();
        vow=new HashMap<>();
        for(String w:wl){
            exact.add(w);
            String l=w.toLowerCase();
            cap.putIfAbsent(l,w);
            vow.putIfAbsent(dev(l),w);
        }
        String[] ans=new String[qs.length];
        for(int i=0;i<qs.length;i++) ans[i]=check(qs[i]);
        return ans;
    }
    
    String check(String q){
        if(exact.contains(q)) return q;
        String l=q.toLowerCase();
        if(cap.containsKey(l)) return cap.get(l);
        String d=dev(l);
        if(vow.containsKey(d)) return vow.get(d);
        return "";
    }
    
    String dev(String w){
        StringBuilder sb=new StringBuilder();
        for(char c:w.toCharArray()) sb.append("aeiou".indexOf(c)>=0?'*':c);
        return sb.toString();
    }
}
