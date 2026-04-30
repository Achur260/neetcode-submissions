class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            
             if (str.equals("+")){
                int top = stack.pop();
                int bottom = stack.pop();

                int sum = top + bottom;
                stack.push(sum);

            } else if (str.equals("-")) {
                int top = stack.pop();
                int bottom = stack.pop();

                int diff = bottom - top;
                stack.push(diff);
            } else if (str.equals("*")) {
                int top = stack.pop();
                int bottom = stack.pop();

                int mult = top * bottom;
                stack.push(mult);
            } else if (str.equals("/")){
                int top = stack.pop();
                int bottom = stack.pop();

                int div = bottom / top;
                stack.push(div);
            } else {
                int num = Integer.parseInt(str);
                stack.add(num);

            } 
        }


        return stack.pop();
        
    }
}
