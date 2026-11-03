package Z2025.Z_Tree;

import java.util.*;

public class T558 {

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

    class Solution {
        public Node intersect(Node quadTree1, Node quadTree2) {
            if(quadTree1.isLeaf){
                if(quadTree1.val){
                    return quadTree1;
                }
                else{
                    return quadTree2;
                }
            }

            if(quadTree2.isLeaf){
                if(quadTree2.val){
                    return quadTree2;
                }
                else{
                    return quadTree1;
                }
            }

            Node tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node tr = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

            if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf &&
                    tl.val == tr.val && tl.val == bl.val && tl.val == br.val){
                return new Node(tl.val, true, null, null, null, null);
            }

            return new Node(false, false, tl, tr, bl, br);
        }
    }

}
