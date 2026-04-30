class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (n1,n2) -> {
            return n1[0] - n2[0];
        });

        int prevEnd = Integer.MIN_VALUE;

        int count = 0;

        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                prevEnd = interval[1];
            } else {
                prevEnd = Math.min(prevEnd, interval[1]);
                count++;
            } 
            
        }

        return count;
        
    }
}
