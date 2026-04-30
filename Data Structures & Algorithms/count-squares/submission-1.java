class CountSquares {

    HashMap<List<Integer>, Integer> hs;

    public CountSquares() {
        hs = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> p1 = Arrays.asList(point[0], point[1]);
        
        hs.put(p1, hs.getOrDefault(p1, 0)+1);
    }
    
    public int count(int[] point) {
        int c = 0;
        System.out.println(Arrays.toString(point));
        System.out.println();
        for (List<Integer> p2 : hs.keySet()) {
            if (Math.abs(point[1] - p2.get(1)) == Math.abs(point[0] - p2.get(0)) && p2.get(1) != point[1]) {
                
                System.out.println((p2));

                List<Integer> p3 = Arrays.asList(point[0], p2.get(1));
                List<Integer> p4 = Arrays.asList(p2.get(0), point[1]);
                System.out.println((p3));
                System.out.println((p4));
                System.out.println(hs.containsKey(p3));
                System.out.println(hs.containsKey(p4));
                System.out.println();



                if (hs.containsKey(p3) && hs.containsKey(p4)){
                    c += hs.get(p2)*hs.get(p3)*hs.get(p4);
                }
            }
        }

        return c;
    }
}
