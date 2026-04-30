class TimeMap {


    HashMap<String, List<Object[]>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.putIfAbsent(key, new ArrayList<Object[]>());

        hm.get(key).add(new Object[] {value, timestamp});
    }
    
    public String get(String key, int timestamp) {

        if (!hm.containsKey(key)) {
            return "";
        }
        List<Object[]> x = hm.get(key);

        int start = 0;
        int end = x.size() - 1;

        while (start <= end) {
            int mid = (start + end)/2;

            if ((int) x.get(mid)[1] == timestamp) {
                return (String) x.get(mid)[0];
            } else if ((int) x.get(mid)[1] < timestamp) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        if (end == -1) {
            return "";
        }
        return (String) x.get(end)[0];


    }
}
