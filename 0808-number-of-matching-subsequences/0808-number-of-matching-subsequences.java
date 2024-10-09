class Solution {

    public int solve(int i, int j, String s, String curr, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int same = 0;
        if(curr.charAt(j) == s.charAt(i)) same = 1 + solve(i-1, j-1, s, curr, dp);
        int notSame = solve(i-1, j, s, curr, dp);
        return dp[i][j] = same + notSame;
    }

    int binSearchUpperBound(List<Integer> integers, int si, int ei, int lastIndex) {
        while (si <= ei && si < integers.size()) {
            int mid = si + (ei - si) / 2;
            
            if (integers.get(mid) > lastIndex) {
                ei = mid - 1;  // Move to the left half
            } else {
                si = mid + 1;  // Move to the right half
            }
        }
        
        return si;  // This is where the upper bound would be
    }

    public boolean solveBS(String s, String curr, HashMap<Character, ArrayList<Integer>> map) {
        int n = s.length();
        int m = curr.length();
        boolean flag = true;
        int idx = -1;
        for(int i = 0; i<m; i++) {
            char currChar = curr.charAt(i);
            if(flag == false) return false;
            if(!map.containsKey(currChar)) {
                return false;
            } else {
                ArrayList<Integer> currIdxList = map.get(currChar);
                int size = currIdxList.size();
                int l = 0, h = size - 1;
                int res = -1;
                while(l<=h) {
                    int mid = (l+h)/2;
                    if(currIdxList.get(mid) > idx) {
                        res = mid;
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                if(res == -1) return false;
                idx = currIdxList.get(res);
            }
        }
        if(flag) return true;
        return false;
    }

    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int len = words.length;
        int count = 0;
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++) {
            char currChar = s.charAt(i);
            if(!map.containsKey(currChar)) {
                map.put(currChar, new ArrayList<>());
            }
            ArrayList<Integer> arr = map.get(currChar);
            arr.add(i);
            map.put(currChar, arr);
        }

        for(int i = 0; i<len; i++) {
            boolean currCount = solveBS(s, words[i], map);
            if(currCount) count++;
        }
        return count;
    }
}