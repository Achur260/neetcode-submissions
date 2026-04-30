class Solution {
    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                continue;
            } else if (s.charAt(i) == ']'){
                
                String curr = "";

                while (!stack.isEmpty() && !Character.isDigit(stack.peek().charAt(0))) {
                    curr = stack.pop() + curr;
                }


                if (!stack.isEmpty()) {
                    curr = curr.repeat(Integer.parseInt(stack.pop()));
                }

                stack.push(curr);
            } else if (Character.isDigit(s.charAt(i))) {
                int prevI = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }

                stack.add(s.substring(prevI, i));
                i--;
            }
            else {
                stack.push(s.charAt(i) + "");
            }
        }

        String res = "";

        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }

        return res;
        
    }
}