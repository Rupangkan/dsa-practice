class Solution {
    public int prefixCount(String[] words, String prefix) {
        int count = 0;
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }
        return trie.getPrefixCount(prefix);
    }

    private class Trie {

        class TrieNode {
            TrieNode[] children;
            int prefixCount;

            TrieNode() {
                children = new TrieNode[26];
                prefixCount = 0;
            }
        }

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (currentNode.children[ch - 'a'] == null) {
                    currentNode.children[ch - 'a'] = new TrieNode();
                }
                currentNode = currentNode.children[ch - 'a'];
                currentNode.prefixCount++;
            }
        }

        public int getPrefixCount(String prefix) {
            TrieNode currentNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (currentNode.children[ch - 'a'] == null) {
                    return 0;
                }
                currentNode = currentNode.children[ch - 'a'];
            }
            return currentNode.prefixCount;
        }
    }
}