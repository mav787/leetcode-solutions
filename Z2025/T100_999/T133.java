package Z2025.T100_999;
import java.util.*;

public class T133 {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Set<Node> set = new HashSet<>();
        Map<Node, Node> map = new HashMap<>();

        cloneNodes(node, map);
        cloneEdges(node, map, set);
        return map.get(node);
    }

    private void cloneNodes(Node node, Map<Node, Node> map){
        if(map.containsKey(node)){
            return;
        }

        map.put(node, new Node(node.val));
        for(Node neighbor : node.neighbors){
            cloneNodes(neighbor, map);
        }
    }

    private void cloneEdges(Node node, Map<Node, Node> map, Set<Node> set){
        if(set.contains(node)){
            return;
        }

        set.add(node);
        Node clone = map.get(node);

        for(Node neighbor : node.neighbors){
            clone.neighbors.add(map.get(neighbor));
            cloneEdges(neighbor, map, set);
        }
    }

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
}