class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        //1. Build the Graph
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        buildGraph(equations, values, graph);

        double[] res = new double[queries.size()];
        
        for(int i=0; i<queries.size(); i++){
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if(!graph.containsKey(src) || !graph.containsKey(dst)){
                res[i] = -1.0;
                continue;
            }

            if (src.equals(dst)) {
                res[i] = 1.0;
                continue;
            }


            res[i] = bfs(src, dst, graph);
        }
        return res;
    }


    public double bfs(String src, String dest, HashMap<String, HashMap<String, Double>> graph){
        Set<String> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 1.0));
        visited.add(src);

        while (!q.isEmpty()) {
            Pair t = q.poll();
            String current = t.node;
            double value = t.val;

            // if (current.equals(dest)) {
            //     return value;
            // }

            for (String neighbor : graph.get(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    double weight = graph.get(current).get(neighbor);
                    if (neighbor.equals(dest)) {
                        return value * weight;  // return immediately
                    }
                    q.add(new Pair(neighbor, value * weight));
                    visited.add(neighbor);
                }
            }
        }
        return -1.0;
    }



    public void buildGraph(List<List<String>> equations, double[] values, HashMap<String, HashMap<String, Double>> graph){
        for(int i = 0; i<equations.size(); i++){
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());

            graph.get(from).put(to, val);
            graph.get(to).put(from, 1/val);
        }
    }
}

class Pair{
    String node;
    Double val;

    public Pair(String node, Double val){
        this.node = node;
        this.val = val;
    }
}