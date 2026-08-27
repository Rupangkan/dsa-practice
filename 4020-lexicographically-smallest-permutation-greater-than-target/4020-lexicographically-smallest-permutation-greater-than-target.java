class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        int n = target.length();

        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';

            if (cnt[x] > 0) {
                cnt[x]--;

                if (canFormGreater(cnt, target, i + 1)) {
                    ans.append(target.charAt(i));
                    continue;
                }

                cnt[x]++;
            }

            for (int c = x + 1; c < 26; c++) {
                if (cnt[c] == 0) continue;

                cnt[c]--;
                ans.append((char) ('a' + c));
                return ans.append(getMinString(cnt)).toString();
            }

            return "";
        }

        return "";
    }

    private boolean canFormGreater(int[] cnt, String target, int start) {
        return getMaxString(cnt).compareTo(target.substring(start)) > 0;
    }

    private String getMaxString(int[] cnt) {
        StringBuilder res = new StringBuilder();

        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                res.append((char) ('a' + i));
            }
        }

        return res.toString();
    }

    private String getMinString(int[] cnt) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                res.append((char) ('a' + i));
            }
        }

        return res.toString();
    }
}