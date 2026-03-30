class Solution{
    public boolean checkStrings(String a,String b){
        if(a.length()!=b.length()) return false;

        int[] c1=new int[256],c2=new int[256];

        for(int i=0;i<a.length();i++){
            int o=(i&1)<<7;
            c1[o+a.charAt(i)]++;
            c2[o+b.charAt(i)]++;
        }
        return Arrays.equals(c1,c2);
    }
}