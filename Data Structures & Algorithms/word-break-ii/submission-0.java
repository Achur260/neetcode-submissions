class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        

        List<String> ans = new ArrayList<String>();

        helper(s, wordDict, 0, new StringBuilder(), ans);
        return ans;

        
    }

    public void helper(String s, List<String> wordDict, int i, StringBuilder sb, List<String> ans) {
        
        
        if (i == s.length()) {
            ans.add(sb.toString());
            return;
        }

        for (String word : wordDict) {
            String rem = s.substring(i, Math.min(s.length(), i + word.length()));
            if (rem.equals(word)) {
                int prevEnd = sb.length();
                if (sb.length() == 0) {
                    sb.append(rem);
                    
                } else {
                    sb.append(" " + rem);
                }



                helper(s, wordDict, i + word.length(), sb, ans);
                sb.delete(prevEnd, sb.length());
            }
        }
    }
}