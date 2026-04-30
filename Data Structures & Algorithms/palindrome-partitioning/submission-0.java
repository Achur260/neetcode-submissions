class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(ans, new ArrayList<String>(), s, 0, 0);
        return ans;
        
        
    }

    public void helper(List<List<String>> ans, List<String> curr, String s, int start, int end) {
        if (end == s.length()) {

            if (start == end)
                ans.add(new ArrayList<String>(curr));
            return;
        }

        if (isPalindrome(s.substring(start, end+1))) {
            curr.add(s.substring(start, end+1));
            helper(ans, curr, s, end+1, end+1);
            curr.removeLast();
        }

        helper(ans, curr, s, start, end+1);
        




    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
