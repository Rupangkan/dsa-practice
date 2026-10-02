class Solution {
    public void solve(int left, int right, int n, String curr, List<String> ans) {
        if(n*2 == curr.length()) {
            ans.add(curr);
            return;
        }

        if(left > right) {
            solve(left, right + 1, n, curr+")", ans);
        }

        if(n > left) {
            solve(left + 1, right, n, curr+"(", ans);
        }

    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        solve(0, 0, n, "", ans);
        return ans;
    }
}