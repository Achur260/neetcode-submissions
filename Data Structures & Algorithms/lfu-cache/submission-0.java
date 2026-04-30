class LFUCache {

    Map<Integer, Node> map;
    Map<Integer, NodeList> counts;
    int size;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        counts = new HashMap<>();
        size = 0;
        this.capacity = capacity;
        min = 1;
        
    }
    
    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

            NodeList cNode = counts.get(node.count);

            cNode.removeNode(node);

            if (cNode.size == 0) {
                counts.remove(node.count);
                if (node.count == min) {
                    min = node.count+1;
                }
            }

            node.count++;
            counts.putIfAbsent(node.count, new NodeList());
            NodeList newList = counts.get(node.count);

            newList.addNode(node);
            return node.val;
        
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;

            NodeList cNode = counts.get(node.count);

            cNode.removeNode(node);

            if (cNode.size == 0) {
                counts.remove(node.count);
                if (node.count == min) {
                    min = node.count+1;
                }
            }

            node.count++;
            counts.putIfAbsent(node.count, new NodeList());
            NodeList newList = counts.get(node.count);

            newList.addNode(node);
        } else {

            if (size == capacity) {
            NodeList nl = counts.get(min);
            Node d = nl.removeHead();
            size--;
            map.remove(d.key);

            if (nl.size == 0) {
                counts.remove(min);
            }

        }
            Node n = new Node(key, value);
            min = 1;

            counts.putIfAbsent(1, new NodeList());
            NodeList nl = counts.get(1);
            nl.addNode(n);
            map.put(key, n);

            size++;
        }
    }
}

class Node {
    int val;
    int key;
    Node next;
    Node prev;
    int count;

    Node (int key, int val) {
        this.val = val;
        this.key = key;
        count = 1;
    }
}

class NodeList {
    Node head;
    Node tail;
    int size;

    NodeList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addNode(Node node) {

        Node nPrev = tail.prev;
        nPrev.next = node;
        node.prev = nPrev;
        node.next = tail;
        tail.prev = node;
        size++;

    }

    public void removeNode(Node node) {
        Node nNext = node.next;
        Node nPrev = node.prev;
        nPrev.next = nNext;
        nNext.prev = nPrev;
        size--;

    }

    public Node removeHead() {

        if (size == 0)
            return new Node(-1, -1);
        Node curr = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return curr;
    }
}