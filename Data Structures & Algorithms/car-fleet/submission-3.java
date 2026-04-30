class Solution {
    public int carFleet(int target, int[] position, int[] speed) {


        Integer[] arr = new Integer[speed.length];

        for (int i = 0; i < speed.length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, (Integer n1, Integer n2) -> {
            return position[n1]-position[n2];
        });


        Stack<Integer> stack = new Stack<Integer> ();

        for (int i = 0; i < position.length; i++) {
            int currIndex = arr[i];
            int currPos = position[currIndex];
            int currSpeed = speed[currIndex];
            double firstTarget = ((double) (target-currPos))/((double)currSpeed);
            while(!stack.isEmpty() && speed[stack.peek()] >= currSpeed) {

                int nextPos = position[stack.peek()];
                int nextSpeed = speed[stack.peek()]; 
                double secondTarget = ((double) (target-nextPos))/((double)nextSpeed);

                if (secondTarget <= firstTarget) {
                    stack.pop();
                } else {
                    break;
                }

            }

            stack.add(currIndex);
        }


        return stack.size();
        
    }
}
