class Solution {
    public String simplifyPath(String path) {

        String[] arr = path.split("/");

        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            String rep = a.replaceAll("^/+", "");
            arr[i] = rep;
        }

        Stack<String> stack = new Stack<>();
        int count = 0;


        for (String str : arr) {
            if (str.equals("")) {
                continue;
            }

            if (str.equals(".")) {

                continue;
            }

            if (str.equals("..")) {
                if (!stack.isEmpty()){
                stack.pop();
                count--;}
            }

            else {
                stack.push(str);
                count++;
            }

        }



        String s = "";

        if (count == 0) {
            return "/";
        }

        while (!stack.isEmpty()) {
            s = "/" + stack.pop() + s;
        }

        return s;
        
    }
}