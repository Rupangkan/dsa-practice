class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        int n = s.length();

        for(int i = 0; i<n; i++) {
            char curr = s.charAt(i);
            if(curr == ')' || curr == '}' || curr == ']') {
                if(st.isEmpty()) return false;
                if(curr == ')') {
                    if(st.peek() != '(') return false;
                } else if(curr == '}') {
                    if(st.peek() != '{') return false;
                } else if(curr == ']') {
                    if(st.peek() != '[') return false;
                }
                st.pop();
            } else {
                st.add(curr);
            }
        }
        return st.isEmpty();
    }
}