class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int i = 0; 

        ArrayList<int[]> arr = new ArrayList<>();

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            arr.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]) {
            newInterval = new int[] {
                Math.min(newInterval[0], intervals[i][0]),
                Math.max(newInterval[1], intervals[i][1])
            };
            i++;
        }

        arr.add(newInterval);

        while(i < intervals.length) {
            arr.add(intervals[i]);
            i++;
        }


        int[][] res = new int[arr.size()][];

        for (int j = 0; j < res.length; j++) {
            res[j] = arr.get(j);
        }

        return res;
    }
}
