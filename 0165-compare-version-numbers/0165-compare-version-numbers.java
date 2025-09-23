class Solution {
    public int compareVersion(String v1,String v2){
        int i=0,j=0,n=v1.length(),m=v2.length();
        while(i<n||j<m){
            int a=0,b=0;
            while(i<n&&v1.charAt(i)!='.')a=a*10+(v1.charAt(i++)-'0');
            while(j<m&&v2.charAt(j)!='.')b=b*10+(v2.charAt(j++)-'0');
            if(a<b)return -1;
            if(a>b)return 1;
            i++;j++;
        }
        return 0;
    }
}
