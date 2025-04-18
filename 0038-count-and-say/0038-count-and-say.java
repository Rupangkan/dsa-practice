class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s = countAndSay(n-1);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<s.length(); i++){
            int cou = 1;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                cou++;
                i++;
            }
            sb.append(cou);
            sb.append(s.charAt(i));
        }
        return sb.toString();
        
    }
}