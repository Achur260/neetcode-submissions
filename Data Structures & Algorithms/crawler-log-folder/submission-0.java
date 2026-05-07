class Solution {
    public int minOperations(String[] logs) {

        int curr = 0;


        for (String log : logs) {
            if (log.equals("../")){
                if (curr != 0) {
                    curr--;
                }
            } else if (log.equals("./")) {
            } else {
                curr++;
            }
        }


        return curr;
        
    }
}