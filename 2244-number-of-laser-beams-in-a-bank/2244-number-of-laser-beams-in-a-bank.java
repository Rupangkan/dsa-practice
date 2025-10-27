class Solution {
    
    public int numberOfBeams(String[] bank) {
        int res = 0, prev = 0;
        for (String row : bank) {
            int cnt = 0;
            for (char c : row.toCharArray()) 
                if (c == '1') cnt++;
            if (cnt > 0) {
                res += prev * cnt;
                prev = cnt;
            }
        }
        return res;
    }
}
