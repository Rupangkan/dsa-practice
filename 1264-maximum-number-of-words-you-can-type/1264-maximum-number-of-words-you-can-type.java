class Solution {
    public int canBeTypedWords(String t,String b){
        Set<Character> bad=new HashSet<>();
        for(char c:b.toCharArray()) bad.add(c);
        int res=0; boolean br=false;
        for(int i=0;i<=t.length();i++){
            if(i<t.length()&&bad.contains(t.charAt(i))) br=true;
            if(i==t.length()||t.charAt(i)==' '){
                if(!br) res++;
                br=false;
            }
        }
        return res;
    }
}