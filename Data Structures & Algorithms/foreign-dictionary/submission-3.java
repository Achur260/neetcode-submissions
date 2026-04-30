class Solution {
    public String foreignDictionary(String[] words) {

        if (words.length == 1) {
            return words[0];
        }

        HashMap<Character, List<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            if (word1.length() > word2.length() && word1.substring(0, word2.length()).equals(word2)) 
                return "";
            
            int len = Math.min(word1.length(), word2.length()); 
            boolean diff = false;
            for (int j = 0; j < len; j++) {
                if (!diff && word1.charAt(j) != word2.charAt(j)) {
                    graph.putIfAbsent(word1.charAt
                    (j), new LinkedList<Character>());
                    graph.putIfAbsent(word2.charAt
                    (j), new LinkedList<Character>());
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    inDegree[word2.charAt(j) - 'a']++;
                    diff = true;
                } else {
                    graph.putIfAbsent(word1.charAt(j), new LinkedList<>());
                    graph.putIfAbsent(word2.charAt(j), new LinkedList<>());
                }
            }
            
        }

        
        Queue<Character> q = new LinkedList<>();


        for (char c : graph.keySet()) {
            if (inDegree[c-'a'] == 0) {
                q.add(c);
                inDegree[c-'a'] = -1;
            }
        }

        int size = q.size();

        System.out.println(graph.keySet());

        StringBuilder sb = new StringBuilder();

        while(size > 0) {
            char curr = q.remove();
            sb.append(curr);
            size--;

            for (char neighbor : graph.get(curr)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    inDegree[neighbor - 'a'] = -1;
                    q.add(neighbor);
                }
            }

            if (size == 0) {
                size = q.size();
            }

        }

        System.out.println(sb.toString());
        for (int s : inDegree) {
            if (s > 0) {
                return "";
            }
        }


        return  sb.toString();

        

      
    }
}
