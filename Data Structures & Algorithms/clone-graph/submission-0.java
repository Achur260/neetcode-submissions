/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> hm;
    public Node cloneGraph(Node node) {
        hm = new HashMap<Node, Node>();

        return clone(node);

        
    }

    public Node clone(Node node) {
        if (node == null) {
            return node;
        } else if (hm.containsKey(node)) {
            return hm.get(node);
        }

        Node repNode = new Node(node.val);
        hm.put(node, repNode);


        ArrayList<Node> neigh = new ArrayList<>();

        for (Node neighbor : node.neighbors) {
            neigh.add(clone(neighbor));
        } 


        repNode.neighbors = neigh;
        return repNode;

    }
}