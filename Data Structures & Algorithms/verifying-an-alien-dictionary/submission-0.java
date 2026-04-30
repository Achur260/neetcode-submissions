class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alph = new int[26];

        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            alph[ch - 'a'] = i;
        }

        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            boolean truth = false;

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                
                if (word1.charAt(j) != word2.charAt(j)) {
                    char ch1 = word1.charAt(j);
                    char ch2 = word2.charAt(j);

                    if (alph[ch1-'a'] > alph[ch2-'a']) {
                        return false;
                    } else {
                        truth = true;
                        break;
                    }
                }

                
            }
            if (word1.length() > word2.length() && !truth) {
                return false;
            }
        }

        return true;
        
    }
}