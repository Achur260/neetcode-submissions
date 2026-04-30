/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid,0,0,grid.length-1,grid[0].length-1);
        
    }

    public Node construct(int[][] grid, int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return new Node(grid[x1][y1] == 0 ? false : true, true, null,null,null,null);           
        } if (x1 > x2 || y1 > y2) {
            return null;
        }

        int midX = (x1+x2)/2;
        int midY = (y1+y2)/2;

        Node topLeft = construct(grid, x1, y1, midX, midY);
        Node bottomLeft = construct(grid, midX+1, y1, x2, midY);
        Node topRight = construct(grid, x1, midY+1, midX, y2);
        Node bottomRight = construct(grid, midX+1, midY+1, x2, y2);

        if (topLeft.val == topRight.val  && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            return new Node(topLeft.val, true, null,null,null,null);
        } else {
            return new Node(false,false,topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}