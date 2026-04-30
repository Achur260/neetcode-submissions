class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String str : strs) {
            int[] counts = new int[26];

            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int num : counts) {
                sb.append(num + " ");
            }

            hm.putIfAbsent(sb.toString(), new ArrayList<>());
            hm.get(sb.toString()).add(str);
        }

        List<List<String>> ans = new ArrayList<>(hm.values());

        return ans;
        
    }
}
