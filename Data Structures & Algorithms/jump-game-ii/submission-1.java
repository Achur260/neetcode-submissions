class Solution {
    public int jump(int[] nums) {
        
        int nextStep = 0;
        int curr = 0;
        int after = 0;
        int jump  = 0;

        while(curr <= nextStep) {
            if (nextStep >=nums.length - 1)
                    return jump;
            if (nextStep == curr) {
                after = Math.max(after, curr + nums[curr]);
                nextStep = after;
                curr++;
                jump++;
                
            } else {
                after = Math.max(after, curr + nums[curr]);
                curr++;
            }   
        }


        return jump;
    }
}
