class Solution {
    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<String>();
        ans.add("");
        HashMap<Character, List<Character>> hm = new HashMap<>();
        hm.put('2', Arrays.asList('a', 'b', 'c'));
        hm.put('3', Arrays.asList('d', 'e', 'f'));
        hm.put('4', Arrays.asList('g', 'h', 'i'));
        hm.put('5', Arrays.asList('j', 'k', 'l'));
        hm.put('6', Arrays.asList('m', 'n', 'o'));
        hm.put('7', Arrays.asList('p', 'q', 'r', 's'));
        hm.put('8', Arrays.asList('t', 'u', 'v'));
        hm.put('9', Arrays.asList('w', 'x', 'y', 'z'));



        for (int i = 0;  i < digits.length(); i++) {
            List<String> copy = new ArrayList(ans);
            ans.clear();

            for (String s : copy) {
                for (char ch : hm.get(digits.charAt(i))) {
                    String newS = s + ch;
                    ans.add(newS);
                }
            }


        }

        return ans;
        
    }


}
