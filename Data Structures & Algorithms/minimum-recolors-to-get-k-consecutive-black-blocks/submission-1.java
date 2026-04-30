class Solution {
    public int minimumRecolors(String blocks, int k) {

        int start = 0;
        int end = 0;
        int rec = 0;
        int maxRec = Integer.MAX_VALUE;
        while (end < k) {
            if (blocks.charAt(end) == 'W') {
                rec++;
            }
            end++;
        }

        end--;

        maxRec = Math.min(rec, maxRec);

        while (end < blocks.length()-1) {

            System.out.println(start + " " + end + " " + rec + " " + maxRec);
            if (blocks.charAt(start) == 'W') {
                rec--;
            } 

            start++;

            if (blocks.charAt(end+1) == 'W') {
                rec++;
            }

            end++;

            maxRec = Math.min(rec, maxRec);


            


        }


        return maxRec;
        
    }
}