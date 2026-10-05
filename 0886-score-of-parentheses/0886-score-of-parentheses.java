class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0, n = s.length();

        for(int i = 0; i<n; i++) {
            if(s.charAt(i) == '(') {
                st.push(score);
                score = 0;
            } else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }
}