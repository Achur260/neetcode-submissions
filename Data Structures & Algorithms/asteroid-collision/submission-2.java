class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
           
            if (asteroid < 0) {
                while (!stack.isEmpty()) {
                    if (Math.abs(asteroid) > Math.abs(stack.peek()) && stack.peek() > 0) {
                        stack.pop();
                    } else {
                        break;
                    }
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
            }

            else {
                stack.push(asteroid);
            }
           
        }


        int[] ans = new int[stack.size()];

        for (int i = ans.length-1; i>-1; i--) {
            ans[i] = stack.pop();
        }


        return ans;
        
    }
}