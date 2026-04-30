class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];



        Stack<Integer> stack = new Stack<>();
        int prevIndex = 0;
        for (int i = 0; i < temperatures.length; i++) {

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                
                res[stack.peek()] = i - stack.pop();
            }

            stack.push(i);


        }

        return res;
        
    }
}
