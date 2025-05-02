class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length, f = 0;
        int[] fArr = new int[n];

        for(int i = 0; i<n; i++) {
            if(arr[i] == 'R') f = n;
            else if(arr[i] == 'L') f = 0;
            else f = Math.max(f - 1, 0);
            fArr[i] += f;
        }

        f = 0;
        for(int i=n-1; i>=0; i--) {
            if(arr[i] == 'L') f = n;
            else if(arr[i] == 'R') f = 0;
            else f = Math.max(f - 1, 0);
            fArr[i] -= f;
        }

        StringBuilder ans = new StringBuilder();
        for(int i: fArr) {
            ans.append(i > 0 ? 'R' : i < 0 ? 'L' : '.');
        }
        return ans.toString();
    }
}