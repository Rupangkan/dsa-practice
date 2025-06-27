class Solution {

    private boolean check(String s, String t, int k) {
        int p = 0, c = 0, len = t.length();
        for (char ch : s.toCharArray()) {
            if (ch == t.charAt(p)) {
                if (++p == len) {
                    if (++c == k) return true;
                    p = 0;
                }
            }
        }
        return false;
    }

    private String solve(String s, int k) {
        int[] f = new int[26];
        for (char ch : s.toCharArray()) f[ch - 'a']++;
        List<Character> cand = new ArrayList<>();
        for (int i = 25; i >= 0; i--) if (f[i] >= k) cand.add((char) ('a' + i));

        Queue<String> q = new LinkedList<>();
        for (char ch : cand) q.add("" + ch);
        String res = "";
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.length() > res.length()) res = cur;
            for (char ch : cand) {
                String nxt = cur + ch;
                if (check(s, nxt, k)) q.add(nxt);
            }
        }
        return res;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        return solve(s, k);
    }
}