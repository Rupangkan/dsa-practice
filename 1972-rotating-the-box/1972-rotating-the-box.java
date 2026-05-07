class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;
        char[][] ans = new char[m][n];

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                ans[i][j] = box[j][i];
            }
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n/2; j++) {
                char curr = ans[i][j];
                ans[i][j] = ans[i][n-1-j];
                ans[i][n-1-j] = curr;
            }
        }

        for(int i = 0; i<n; i++) {
            int l = m - 1;
            for(int j = m-1; j>=0; j--) {
                if(ans[j][i] == '#') {
                    ans[j][i] = '.';
                    ans[l][i] = '#';
                    l--;
                }
                if(ans[j][i] == '*') l = j - 1;
            }
        }
        return ans;
    }
}