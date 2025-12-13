class Solution {
    public List<String> validateCoupons(String[] code, String[] line, boolean[] active) {
        List<String>[] b = new ArrayList[4];
        for (int i = 0; i < 4; i++) b[i] = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!active[i] || code[i].length() == 0) continue;
            int id = id(line[i]);
            if (id == -1) continue;
            if (!ok(code[i])) continue;
            b[id].add(code[i]);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Collections.sort(b[i]);
            res.addAll(b[i]);
        }
        return res;
    }

    private int id(String s) {
        if (s.equals("electronics")) return 0;
        if (s.equals("grocery")) return 1;
        if (s.equals("pharmacy")) return 2;
        if (s.equals("restaurant")) return 3;
        return -1;
    }

    private boolean ok(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') return false;
        }
        return true;
    }
}
