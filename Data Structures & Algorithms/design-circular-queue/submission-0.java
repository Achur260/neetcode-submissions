class MyCircularQueue {

    int size;
    Node head;
    Node tail;
    int k;

    public MyCircularQueue(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        this.k = k;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (size == k) {
            return false;
        }
        Node node = new Node(value);
        Node tprev = tail.prev;
        tprev.next = node;
        node.prev = tprev;
        tail.prev = node;
        node.next = tail;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }

        Node newNext = head.next.next;
        head.next = newNext;
        newNext.prev = head;
        size--;
        return true;
    }
    
    public int Front() {
        if (size == 0) {
            return -1;
        }

        return head.next.val;
        
    }
    
    public int Rear() {
        if (size == 0) {
            return -1;
        }

        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */