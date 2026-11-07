package Z2025.T100_999;

import java.util.*;

public class T332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();
        if(tickets == null || tickets.size() == 0){
            return res;
        }
        Map<String, Queue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);

            Queue<String> heap = map.getOrDefault(src, new PriorityQueue<>());
            heap.offer(dest);
            map.put(src, heap);
        }

        helper("JFK", map, res);

        return res;
    }

    private void helper(String airport,
                        Map<String, Queue<String>> map,
                        List<String> res) {

        Queue<String> neighbors = map.get(airport);

        while (neighbors != null && !neighbors.isEmpty()) {
            String next = neighbors.poll();
            helper(next, map, res);
        }

        res.add(0, airport);
    }

}
