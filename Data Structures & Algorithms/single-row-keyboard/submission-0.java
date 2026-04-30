class Solution {
    public int calculateTime(String keyboard, String word) {


        int[] indexes = new int[26];


        for (int i = 0; i < keyboard.length(); i++) {
            indexes[keyboard.charAt(i) - 'a'] = i;
        }


        int count = 0;

        int prevChar = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);


            count += Math.abs(indexes[ch - 'a'] - prevChar);
            prevChar = indexes[ch -'a'];


        }


        return count;
        
    }
}
