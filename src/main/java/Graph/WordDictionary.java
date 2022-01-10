package Graph;

// 211
// Trie: no val at node but a Map {char, nextNode}
// extra boolean to indicate end
// no root node, extra node at the end with just the bool
// traverse using a combination of for loop and recursion
// word of length N. add: O(N), search: O(M)

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root = new TrieNode();

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); ++i) {
            if (node.children[word.charAt(i)-'a'] == null) {
                node.children[word.charAt(i)-'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i)-'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchWord(word, 0, root);
    }

    private boolean searchWord(String word, int i, TrieNode node) {
        if (node == null) return false;
        if (i == word.length()) return node.isWord;
        if (word.charAt(i) == '.') {
            for (TrieNode tn : node.children) {
                if (searchWord(word, i+1, tn)) return true;
            }
            return false;
        }
        return searchWord(word, i+1, node.children[word.charAt(i)-'a']);
    }
}
