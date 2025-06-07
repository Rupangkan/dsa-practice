class Solution {
    private String solveCore(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder out = new StringBuilder();
        int ptr = 0;

        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;
            while (!stack.isEmpty() && ok(stack.peek(), freq)) {
                out.append(stack.pop());
            }
        }
        return out.toString();
    }

    private boolean ok(char top, int[] freq) {
        for (int i = 0; i < top - 'a'; i++) {
            if (freq[i] > 0) return false;
        }
        return true;
    }

    public String robotWithString(String s) {
        return solveCore(s);
    }
}