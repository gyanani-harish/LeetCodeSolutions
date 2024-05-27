class Solution {
    /**
    If a node has no incoming edges, it means no other node points to it. Therefore, it must be one of the starting points to reach other nodes.
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            boolean[] hasIncomingEdges = new boolean[n];
            for(List<Integer> edge : edges){
                int toNode = edge.get(1);
                hasIncomingEdges[toNode] = true;
            }
            List<Integer> result = new ArrayList<>();
            for(int i =0;i<n;i++){
                if(!hasIncomingEdges[i]){
                    result.add(i);
                }
            }
            return result;
    }

        
}
