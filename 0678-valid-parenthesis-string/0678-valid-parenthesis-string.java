class Solution {
    public boolean checkValidString(String s) {
        int n = s.length(), min = 0, max = 0;

        for(int i = 0; i<n; i++) {
            if(s.charAt(i) == '(') {
                max++;
                min++;
            }
            else if(s.charAt(i) == ')') {
                max--;
                min--;

            }
            else {
                max++;
                min--;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return min == 0;
    }
}