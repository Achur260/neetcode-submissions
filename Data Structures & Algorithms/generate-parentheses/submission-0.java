class Solution {
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;

        List<String> ans = new ArrayList<String>();

        helper(ans, new StringBuilder(), 0, 0);
        return ans;
    }

    public void helper(List<String> ans, StringBuilder sb, int open, int close) {
        if (sb.length() == 2*n) {
            if (open == n && close == n)
                ans.add(sb.toString());
            return;
        }   

        if (close > open) {
            return;
        }
        
        sb.append('(');
        helper(ans, sb, open+1, close);
        sb.deleteCharAt(sb.length()-1);


        sb.append(')');
        helper(ans, sb, open, close+1);
        sb.deleteCharAt(sb.length()-1);


    }
}
