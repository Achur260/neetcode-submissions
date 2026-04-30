class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> any = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left.push(i);
            } else if (ch == '*') {
                any.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!any.isEmpty()) {
                    any.pop();
                } else {
                    return false;
                }
            }
        }

        while(!left.isEmpty() && !any.isEmpty()) {
            if (left.pop() > any.pop())
                return false;
        }

        return left.isEmpty();
        
    }
}
