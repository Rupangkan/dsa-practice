class Solution {
    private char dfs(Map<Character, List<Character>> g, char u, boolean[] vis) {
        vis[u - 'a'] = true;
        char res = u;
        for (char v : g.getOrDefault(u, List.of())) {
            if (!vis[v - 'a']) {
                char t = dfs(g, v, vis);
                if (t < res) res = t;
            }
        }
        return res;
    }

    public String smallestEquivalentString(String a, String b, String base) {
        Map<Character, List<Character>> g = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            g.computeIfAbsent(a.charAt(i), x -> new ArrayList<>()).add(b.charAt(i));
            g.computeIfAbsent(b.charAt(i), x -> new ArrayList<>()).add(a.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : base.toCharArray()) {
            boolean[] vis = new boolean[26];
            sb.append(dfs(g, ch, vis));
        }
        return sb.toString();
    }
}