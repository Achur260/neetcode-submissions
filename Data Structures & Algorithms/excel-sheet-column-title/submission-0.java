class Solution {
    public String convertToTitle(int columnNumber) {
        
        HashMap<Integer, String> hm = new HashMap<>();
        int i = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            String j = "" + ch;
            j = j.toUpperCase();
            hm.put(i, j);
            i++;
        }   


       String s = "";

        
        while (columnNumber > 0) {
            columnNumber--;
            int x = columnNumber % 26;
            

            s = hm.get(x) + s;
            columnNumber/=26;
            
        }


        return s;
    }
}