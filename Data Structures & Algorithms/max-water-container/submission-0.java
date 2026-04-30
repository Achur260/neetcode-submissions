class Solution {
    public int maxArea(int[] heights) {

        int start = 0;
        int end = heights.length - 1;

        int max = 0;
        while (start < end) {

            if (heights[start] < heights[end]) {
                max = Math.max(max, heights[start]*(end-start));
                start++;
            } else {
                max = Math.max(max, heights[end]*(end-start));
                end--;
            }
        }

        return max;
        
    }
}
