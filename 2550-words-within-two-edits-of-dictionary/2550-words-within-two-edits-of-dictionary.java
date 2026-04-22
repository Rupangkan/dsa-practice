class Solution {

    static class Node {
        Node[] nxt = new Node[26];
        boolean end;
    }

    Node root = new Node();

    void add(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if (cur.nxt[x] == null) cur.nxt[x] = new Node();
            cur = cur.nxt[x];
        }
        cur.end = true;
    }

    boolean go(String s, int i, Node cur, int c) {
        if (cur == null || c > 2) return false;
        if (i == s.length()) return cur.end;

        int x = s.charAt(i) - 'a';

        if (cur.nxt[x] != null && go(s, i + 1, cur.nxt[x], c)) return true;

        if (c < 2) {
            for (int k = 0; k < 26; k++) {
                if (k == x) continue;
                if (cur.nxt[k] != null && go(s, i + 1, cur.nxt[k], c + 1)) return true;
            }
        }

        return false;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        for (String s : dictionary) add(s);

        List<String> ans = new ArrayList<>();
        for (String q : queries) {
            if (go(q, 0, root, 0)) ans.add(q);
        }
        return ans;
    }
}