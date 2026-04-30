class FreqStack {

    Map<Integer, Integer> counts;
    Map<Integer, Stack<Integer>> stacks;
    int maxCount;

    public FreqStack() {
        counts = new HashMap<>();
        stacks = new HashMap<>();
        maxCount = 0;
        
    }
    
    public void push(int val) {
        if (!counts.containsKey(val)) {
            counts.put(val, 1);

            stacks.putIfAbsent(1, new Stack<>());
            stacks.get(1).push(val);

            if (1 > maxCount) {
                maxCount = 1;
            }

        } else {
            int nc = counts.get(val) + 1;
            counts.put(val, nc);

            stacks.putIfAbsent(nc, new Stack<>());
            stacks.get(nc).push(val);

            if (maxCount < nc) {
                maxCount = nc;
            }
        }
    }
    
    public int pop() {
        int res = stacks.get(maxCount).pop();
        counts.put(res, maxCount - 1);

        if (stacks.get(maxCount).isEmpty()) {
            maxCount--;
        }

        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */