class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int edge[] : prerequisites) {
            //customised for this algo
            graph.addEdge(edge[1], edge[0]);
        }
        Set<Integer> set = getListOfNoIncomingVertices(graph);
        boolean isVisited[] = new boolean[numCourses];
        List<Integer> result = new ArrayList<>();
        for (Integer startPoint : set) {
            graph.DFS(startPoint, isVisited, result);
            if (result.size() == numCourses) {
                return result.stream().mapToInt(Integer::intValue).toArray(); // Convert to int array
            }
        }
        return new int[]{};
    }

    private Set<Integer> getListOfNoIncomingVertices(Graph graph) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < graph.adj.size(); i++) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (List<Integer> adjInnerList : graph.adj) {
            set2.addAll(adjInnerList);
        }
        set1.removeAll(set2);
        return set1;
    }

    class Graph {
        int[] indegree;
        public List<List<Integer>> adj;

        public Graph(int n) {
            indegree = new int[n];
            adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int v, int w) {
            adj.get(v).add(w);
            indegree[w]++;
        }

        public void DFS(int x, boolean isVisited[], List<Integer> result) {
            result.add(x);
            isVisited[x] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(x);
            while (!queue.isEmpty()) {
                int polled = queue.poll();
                for (Integer neighbor : adj.get(polled)) {
                    if (!isVisited[neighbor] && (--indegree[neighbor] == 0)) {
                        isVisited[neighbor] = true;
                        result.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }

    }
}