class Solution {
    public String makeLargestSpecial(String s) {
        int bal = 0, start = 0, n = s.length();
        ArrayList<String> parts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            bal += s.charAt(i) == '1' ? 1 : -1;
            if (bal == 0) {
                String mid = makeLargestSpecial(s.substring(start + 1, i));
                parts.add("1" + mid + "0");
                start = i + 1;
            }
        }

        parts.sort((a, b) -> b.compareTo(a));
        StringBuilder sb = new StringBuilder();
        for (String t : parts) sb.append(t);
        return sb.toString();
    }
}
