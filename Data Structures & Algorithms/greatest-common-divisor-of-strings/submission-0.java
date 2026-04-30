class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        String v1 = str1 + str2;
        String v2 = str2 + str1;

        if (!v1.equals(v2)) {
            return "";
        }

        return str1.substring(0, euclid(str1.length(), str2.length()));


        
    }

    public int euclid(int a, int b) {
        if (a < b) {
            return euclid(b, a);
        }


        if (b == 0) {
            return a;
        }

        return euclid (b, a % b);

    }
}