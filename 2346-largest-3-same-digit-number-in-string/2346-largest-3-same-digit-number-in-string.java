class Solution {
    public String largestGoodInteger(String num) {
        char mx = 0;
        for (int i = 0; i + 2 < num.length(); i++) 
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) 
                mx = (char)Math.max(mx, num.charAt(i));
        return mx == 0 ? "" : "" + mx + mx + mx;
    }
}
