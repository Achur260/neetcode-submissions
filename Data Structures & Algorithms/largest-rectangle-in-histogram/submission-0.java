class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int ans = 0;
        for (int i = 0; i < heights.length; i++)  {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int currHeight = heights[stack.pop()];
                int currentWidth = i;
                if (!stack.isEmpty()) {
                    currentWidth -= (stack.peek() + 1);
                }

                ans = Math.max(ans, currHeight*currentWidth);
            }
            
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int currHeight = heights[stack.pop()];
            int currentWidth = heights.length;
            if (!stack.isEmpty()) {
                currentWidth -= (stack.peek() + 1);
            }

            ans = Math.max(ans, currHeight*currentWidth);
        }


        return ans;
        
    }
}
