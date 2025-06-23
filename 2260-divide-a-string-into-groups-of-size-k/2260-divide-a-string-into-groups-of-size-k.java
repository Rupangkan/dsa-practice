class Solution {
    private String[] solve(String s, int k, char fill) {
        List<String> out = new ArrayList<>();
        for (int i = 0; i < s.length(); i += k) {
            int j = Math.min(i + k, s.length());
            String part = s.substring(i, j);
            if (part.length() < k) {
                part += String.valueOf(fill).repeat(k - part.length());
            }
            out.add(part);
        }
        return out.toArray(new String[0]);
    }

    public String[] divideString(String s, int k, char fill) {
        return solve(s, k, fill);
    }
}