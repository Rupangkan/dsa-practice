class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0, r = 0, count = 0;
        int a = -1, b = -1, c = -1;
 
        while(r<n) {
            char temp = s.charAt(r);
            if(temp == 'a') a = r;
            if(temp == 'b') b = r;
            if(temp == 'c') c = r;

            if(a!=-1 && b!=-1 && c!=-1) {
                count += 1 + Math.min(a, Math.min(b, c));
            }
            r++;
        }
        return count;
    }
}