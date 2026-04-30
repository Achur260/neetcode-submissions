class Solution {
    public int trap(int[] height) {

        int l = 0;
        int r = height.length-1;
        int leftMax = height[l];
        int rightMax = height[r];
        int ans = 0;

        while (l < r) {

            if (leftMax > rightMax) {
                ans += rightMax - height[r];
                r--;
                rightMax = Math.max(rightMax, height[r]);
            } else {
                ans += leftMax - height[l];
                l++;
                leftMax = Math.max(leftMax, height[l]);
            }


        }

        return ans;
        
    }
}
