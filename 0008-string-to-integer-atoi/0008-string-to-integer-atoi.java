class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int i = 0;
        int sign = 1;

        while(i < n && s.charAt(i) == ' ') {
            i++;
        }

        if(i == n) return 0;

        if(s.charAt(i) == '+') {
            i++;
        } else if(s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        long res = 0;
        while(i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            // res = res * 10 + digit;
            if((res * 10 + digit) * sign <= min) return min;
            if((res * 10 + digit) * sign >= max) return max;
            res = res * 10 + digit;
            i++;
        }

        return (int)(res * sign);
    }
}