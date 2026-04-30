class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        hs.addAll(wordList);




        Queue<String> queue = new LinkedList<>();
        int step = 1;

        queue.add(beginWord);

        int size = 1;

        while (size > 0) {
            System.out.println(queue);
            System.out.println(step);
            String curr = queue.remove();
            
            if (curr.equals(endWord)) {
                            return step ;
            }    
            size--;

            for (int i = 0; i < curr.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != curr.charAt(i)) {
                        String newS = curr.substring(0, i) + ch + curr.substring(i+1);
                        if (hs.contains(newS)) {
                            hs.remove(newS);
                            queue.add(newS);
                        }
                    }
                }

                
            }

            if (size == 0) {
                    size = queue.size();
                    step++;
            }
        }









        return 0;
        
        
        
    }
}
