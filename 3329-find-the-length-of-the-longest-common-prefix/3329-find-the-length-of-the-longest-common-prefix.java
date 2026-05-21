class TrieNode {
    TrieNode[] next = new TrieNode[10];
}

class Trie {

    TrieNode root = new TrieNode();

    void insert(int x) {
        TrieNode cur = root;

        for (char c : String.valueOf(x).toCharArray()) {
            int d = c - '0';

            if (cur.next[d] == null) {
                cur.next[d] = new TrieNode();
            }

            cur = cur.next[d];
        }
    }

    int query(int x) {
        TrieNode cur = root;
        int res = 0;

        for (char c : String.valueOf(x).toCharArray()) {
            int d = c - '0';

            if (cur.next[d] == null) break;

            res++;
            cur = cur.next[d];
        }

        return res;
    }
}

class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t = new Trie();

        for (int x : arr1) {
            t.insert(x);
        }

        int ans = 0;

        for (int x : arr2) {
            ans = Math.max(ans, t.query(x));
        }

        return ans;
    }
}