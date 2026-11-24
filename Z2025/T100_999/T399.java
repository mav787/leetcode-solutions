package Z2025.T100_999;

import java.util.*;

public class T399 {
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, String> parents = new HashMap<>();
            Map<String, Double> weights = new HashMap<>();

            // weights[x] = x / parents[x]

            for(List<String> equation : equations){
                String a = equation.get(0), b = equation.get(1);

                parents.put(a, a);
                weights.put(a, 1.0);

                parents.put(b, b);
                weights.put(b, 1.0);
            }

            for(int i = 0; i < values.length; i++){
                String a = equations.get(i).get(0);
                String b = equations.get(i).get(1);

                union(a, b, values[i], parents, weights);
            }

            double[] res = new double[queries.size()];

            for(int i = 0; i < queries.size(); i++){
                String a = queries.get(i).get(0);
                String b = queries.get(i).get(1);

                if(!parents.containsKey(a) || !parents.containsKey(b)){
                    res[i] = -1.0;
                    continue;
                }

                String rootA = find(a, parents, weights);
                String rootB = find(b, parents, weights);

                if(!rootA.equals(rootB)){
                    res[i] = -1.0;
                }
                else{
                    res[i] = weights.get(a) / weights.get(b);
                }
            }

            return res;
        }

        private void union(String a, String b, double value, Map<String, String> parents, Map<String, Double> weights){
            String rootA = find(a, parents, weights);
            String rootB = find(b, parents, weights);

            // if(!rootA.equals(rootB)){
            parents.put(rootA, rootB);

            // weights[rootA] = rootA / rootB = rootA / a * a / b * b / rootB
            weights.put(rootA, value * weights.get(b) / weights.get(a));
            //  }
        }

        private String find(String a, Map<String, String> parents, Map<String, Double> weights){
            String parent = parents.get(a);
            if(a.equals(parent)){
                return a;
            }

            String root = find(parent, parents, weights);

            parents.put(a, root);

            // weights[a] = a / root = a / parent * parent / root
            weights.put(a, weights.get(a) * weights.get(parent));

            return root;
        }
    }
}
