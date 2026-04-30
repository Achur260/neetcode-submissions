class LRUCache {

    HashMap<Integer, Node> hm;
    Node head;
    Node tail;
    int cap;
    int currSize;
    public LRUCache(int capacity) {
        hm = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        cap = capacity;
        currSize = 0;

        
    }
    
    public int get(int key) {

        if (!hm.containsKey(key))
            return -1;
        Node curr = hm.get(key);
        Node prev = curr.prev;
        Node next = curr.next;
        prev.next = next;
        next.prev = prev;
        curr.next = head.next;
        curr.next.prev = curr;
        head.next = curr;
        curr.prev = head;


        return curr.val;
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            Node curr = hm.get(key);
            curr.val = value;
            Node prev = curr.prev;
            Node next = curr.next;
            prev.next = next;
            next.prev = prev;
            curr.next = head.next;
            curr.next.prev = curr;
            head.next = curr;
            curr.prev = head;

        } else {

            if (currSize == cap) {
                Node last = tail.prev;
                System.out.println(last.key);
                Node prev = tail.prev.prev;
                prev.next = tail;
                tail.prev = prev;
                hm.remove(last.key);
                currSize--;
            }

            Node curr = new Node(key, value);
            hm.put(key, curr);

            curr.next=head.next;
            curr.next.prev = curr;
            curr.prev = head;
            head.next=curr;
            currSize++;


        }

        
    }
}


class Node {
    int val;
    int key;
    Node next;
    Node prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}
