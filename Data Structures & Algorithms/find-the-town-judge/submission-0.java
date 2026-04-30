class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, Set<Integer>> hm = new HashMap<>();
        int[] inDegree = new int[n];


        for (int[] t : trust) {
            hm.putIfAbsent(t[0]-1, new HashSet<>());
            hm.putIfAbsent(t[1]-1, new HashSet<>());
            hm.get(t[0]-1).add(t[1]-1);
            inDegree[t[1]-1]++;
        }



        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == n-1) {
                if (hm.get(i).size() == 0) {
                    return i+1;
                }
            }
        }


        return -1;
    }
}