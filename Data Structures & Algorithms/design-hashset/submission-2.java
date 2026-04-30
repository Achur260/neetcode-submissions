class MyHashSet {


    boolean[] set;
    public MyHashSet() {
        set = new boolean[1000000];
    }
    
    public void add(int key) {
        // if (key >= set.length) {
        //     boolean[] nset = new boolean[Math.max(key+1, 2*set.length)];
        //     for (int i = 0; i < set.length; i++) {
        //         nset[i] = set[i];
        //     }

        //     set = nset;
        // }

        set[key] = true;
    }
    
    public void remove(int key) {
        if (key >= set.length || !set[key]) {
            return;
        }

        set[key] = false;
    } 
    
    public boolean contains(int key) {
        return key < set.length && set[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */