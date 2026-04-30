class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        int i = 0;
        System.out.println(str);

        List<String> ans = new ArrayList<>();


        while (i < str.length()) {
            int j = i;
            while (j < str.length() && Character.isDigit(str.charAt(j)) ) {
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            String curr = str.substring(j+1, j+1+len);
            System.out.println(curr);
            ans.add(curr);
            i = j+1+len;
        }


        return ans;

    }
}
