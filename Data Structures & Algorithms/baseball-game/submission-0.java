class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op: operations) {
            if(op.equals("D")) {
                stack.push(2*stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("+")) {
                int top = stack.pop();
                int bottom = stack.pop();

                stack.push(bottom);
                stack.push(top);
                stack.push(bottom+top);
            } else {
                int x = Integer.parseInt(op);
                stack.push(x);
            }
        }



        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
        
    }
}