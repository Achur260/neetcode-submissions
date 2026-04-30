class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (n1,n2) -> {
            if (n1[0] == n2[0]) {
                return n1[1] - n2[1];
            }
            return n1[0] - n2[0];
        });

        ArrayList<int[]> arr = new ArrayList<>();

        for (int[] interval : intervals) {
            
            if (arr.isEmpty() || arr.get(arr.size() - 1)[1]  < interval[0]) {
                System.out.println(interval);
                arr.add(interval);
            } else {
                int[] top = arr.get(arr.size() - 1);
                int[] newInterval = new int[]{top[0], Math.max(top[1], interval[1])};
                
                arr.set(arr.size()-1, newInterval);
            }

        }

        int[][] ans = new int[arr.size()][2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr.get(i);
        }

        return ans;
        
    }
}
