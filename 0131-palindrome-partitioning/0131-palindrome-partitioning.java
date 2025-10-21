class Solution {
    private boolean isPalindrome(String s) {
        int low = 0, high = s.length()-1;

        while(low < high) {
            if(s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

    private void test(String s, int n, int idx, List<List<String>> ans, List<String> temp) {
        if(idx == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i<n; i++) {
            if(isPalindrome(s.substring(idx, i+1))) {
                temp.add(s.substring(idx, i+1));
                test(s, n, i + 1, ans, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        test(s, n, 0, ans, new ArrayList<>());
        return ans;
    }
}