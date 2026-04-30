class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (n1,n2) -> {
            return n1[0] - n2[0];
        });


        ArrayList<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            if (!ans.isEmpty() && interval[0] <= ans.getLast()[1]) {
                int[] inter = ans.removeLast();
                ans.add(new int[]{inter[0], Math.max(inter[1], interval[1])});
            } else {
                ans.add(interval);
            }
        }

        int[][] res = new int[ans.size()][2];

        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }


        return res;
    }
}
