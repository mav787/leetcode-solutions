package Z2025.Z_Tree;

import java.util.*;

public class T427 {
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


    class Solution {
        public Node construct(int[][] grid) {
            return solve(grid, 0, 0, grid.length);
        }

        private Node solve(int[][] grid, int x1, int y1, int length) {
            // Return a leaf node if the matrix size is one.
            if (length == 1) {
                return new Node(grid[x1][y1] == 1, true);
            }

            // Recursive calls to the four sub-matrices.
            Node topLeft = solve(grid, x1, y1, length / 2);
            Node topRight = solve(grid, x1, y1 + length / 2, length / 2);
            Node bottomLeft = solve(grid, x1 + length / 2, y1, length / 2);
            Node bottomRight = solve(grid, x1 + length / 2, y1 + length / 2, length / 2);

            // If the four returned nodes are leaf and have the same values
            // Return a leaf node with the same value.
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                    && topLeft.val == topRight.val && topRight.val == bottomLeft.val
                    && bottomLeft.val == bottomRight.val) {
                return new Node(topLeft.val, true);
            }

            // If the four nodes aren't identical, return a non-leaf node with corresponding child pointers.
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

}
