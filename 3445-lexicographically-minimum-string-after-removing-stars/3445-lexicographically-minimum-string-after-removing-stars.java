class Solution {
    private String solve(String s) {
        List<Deque<Integer>> pos = new ArrayList<>();
        for (int i = 0; i < 26; i++) pos.add(new ArrayDeque<>());

        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '*') {
                for (int j = 0; j < 26; j++) {
                    if (!pos.get(j).isEmpty()) {
                        ch[pos.get(j).pop()] = '*';
                        break;
                    }
                }
            } else {
                pos.get(ch[i] - 'a').push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : ch) if (c != '*') sb.append(c);
        return sb.toString();
    }

    public String clearStars(String s) {
        return solve(s);
    }
}