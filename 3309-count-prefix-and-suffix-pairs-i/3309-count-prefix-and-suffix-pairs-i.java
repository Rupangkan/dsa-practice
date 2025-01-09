class Node {

    private Node[] children = new Node[26];

    public boolean hasChild(char c) {
        return children[c - 'a'] != null;
    }

    public void addChild(char c, Node node) {
        children[c - 'a'] = node;
    }

    public Node getChild(char c) {
        return children[c - 'a'];
    }
}

class PrefixSuffixTrie {

    private Node root;

    public PrefixSuffixTrie() {
        root = new Node();
    }

    public void add(String str) {
        Node current = root;
        for (char ch : str.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch, new Node());
            }
            current = current.getChild(ch);
        }
    }

    public boolean hasPrefix(String str) {
        Node current = root;
        for (char ch : str.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }
        return true;
    }
}

class Solution {

    public int countPrefixSuffixPairs(String[] arr) {
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            PrefixSuffixTrie prefixTrie = new PrefixSuffixTrie();
            PrefixSuffixTrie suffixTrie = new PrefixSuffixTrie();

            prefixTrie.add(arr[i]);

            String reversed = new StringBuilder(arr[i]).reverse().toString();
            suffixTrie.add(reversed);

            for (int j = 0; j < i; j++) {
                if (arr[j].length() > arr[i].length()) continue;

                String prefix = arr[j];
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();

                if (prefixTrie.hasPrefix(prefix) && suffixTrie.hasPrefix(reversedPrefix)) {
                    total++;
                }
            }
        }

        return total;
    }
}