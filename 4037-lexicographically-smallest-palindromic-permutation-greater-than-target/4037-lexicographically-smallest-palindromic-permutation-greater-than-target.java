class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) != 0) {
                if (mid != 0) return "";
                mid = (char) ('a' + i);
            }
            cnt[i] /= 2;
        }

        if (n == 1) {
            return s.compareTo(target) > 0 ? s : "";
        }

        StringBuilder left = new StringBuilder();

        for (int i = 0; i < n / 2; i++) {
            for (int c = 0; c < 26; c++) {
                if (cnt[c] == 0) continue;

                cnt[c]--;

                if (canBeGreater(left, (char) ('a' + c), cnt, mid, target)) {
                    left.append((char) ('a' + c));

                    if (left.charAt(i) > target.charAt(i)) {
                        return build(left, cnt, mid);
                    }

                    break;
                }

                cnt[c]++;
            }

            if (left.length() != i + 1) {
                return "";
            }
        }

        String ans = build(left, cnt, mid);
        return ans.compareTo(target) > 0 ? ans : "";
    }

    private boolean canBeGreater(
        StringBuilder prefix,
        char c,
        int[] cnt,
        char mid,
        String target
    ) {
        StringBuilder left = new StringBuilder(prefix);
        left.append(c);

        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                left.append((char) ('a' + i));
            }
        }

        String right = left.reverse().toString();
        left.reverse();

        String palindrome = left.toString() + (mid == 0 ? "" : mid) + right;
        return palindrome.compareTo(target) > 0;
    }

    private String build(StringBuilder left, int[] cnt, char mid) {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                left.append((char) ('a' + i));
            }
        }

        String right = new StringBuilder(left).reverse().toString();
        return left + (mid == 0 ? "" : String.valueOf(mid)) + right;
    }
}