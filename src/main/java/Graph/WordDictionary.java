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

    private class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean word = false;
        Node() {}
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        var curr = root;
        for (char c : chars) {
            curr.children.putIfAbsent(c, new Node());
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return findChar(root, word);
    }

    private boolean findChar(Node node, String word) {
        if (word.equals("")) return node.word;
        char[] chars = word.toCharArray();
        for (int i=0; i<chars.length; ++i) {
            if (node.children.containsKey(chars[i])) node = node.children.get(chars[i]);
            else if (chars[i] != '.') return false;
            else {
                boolean ret = false;
                for (var entry : node.children.entrySet()) {
                    ret = ret || findChar(entry.getValue(), word.substring(i+1));
                }
                return ret;
            }
        }
        return node.word;
    }
}
