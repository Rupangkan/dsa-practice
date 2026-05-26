class Solution {

    public int numberOfSpecialChars(String word) {
        Set<Character> st = new HashSet<>();

        for (char c : word.toCharArray()) {
            st.add(c);
        }

        int ans = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            char u = (char) (c - 'a' + 'A');

            if (st.contains(c) && st.contains(u)) {
                ans++;
            }
        }

        return ans;
    }
}