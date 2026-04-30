class Solution {
    public String longestCommonPrefix(String[] strs) {

        String s1 = strs[0];

        for (int i = 1; i < strs.length; i++) {

            int j = 0;
            while (j < strs[i].length() && j < s1.length() && strs[i].charAt(j) == s1.charAt(j)) {
                j++;
            }

            s1 = strs[i].substring(0, j);
        }


        return s1;
        
    }
}