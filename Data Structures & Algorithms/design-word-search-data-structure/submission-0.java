class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            
            System.out.println(curr.children.keySet());
            System.out.println(c);
            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        
        return helper(word, root, 0);

    }

    public boolean helper(String word, TrieNode curr, int i) {
        if (i == word.length()) {
            return curr.isWord;
        }

        boolean abs = false;

        if (word.charAt(i) == '.') {
            for (Character ch : curr.children.keySet()) {
                if (helper(word, curr.children.get(ch), i+1)) {
                    abs = true;
                }
            }
        } else {
            if (!curr.children.containsKey(word.charAt(i))) {
                abs = false;
            }
            else
             abs = helper(word, curr.children.get(word.charAt(i)), i+1);
        }



        
        System.out.println(word + " " + i + " " + abs);
        return abs;

    }


}

class TrieNode {

    boolean isWord;
    HashMap<Character, TrieNode> children;
    
    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}
