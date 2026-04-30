/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> hm;
    public Node copyRandomList(Node head) {

    hm = new HashMap<>();

    return dfs(head);

        
    }


    public Node dfs(Node node) {

        if (node == null) {
            return null;
        } else if (hm.containsKey(node)) {
            return hm.get(node);
        }


        Node repNode = new Node(node.val); 
        hm.put(node, repNode);

        repNode.next = dfs(node.next);
        repNode.random = dfs(node.random);


        return repNode;


    }
}
