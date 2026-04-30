class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }

        if (minStack.isEmpty() && !stack.isEmpty()) {
            List<Integer> temp = stack.reversed();

            for (int i = temp.size() - 1; i >=0; i--) {
                int t = temp.get(i);
                if (minStack.isEmpty() || minStack.peek() >= t) {
                    minStack.add(t);
                }
            }
        }

        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {

        return minStack.peek();
        
    }
}
