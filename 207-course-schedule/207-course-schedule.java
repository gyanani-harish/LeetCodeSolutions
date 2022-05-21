class Solution {
    Map<Integer, Set<Integer>> graph = null;
    Map<Integer, Boolean> ans = new HashMap<>();
    private static List<List<Integer>> convert(int[][] twoDArray) {
        List<List<Integer>> result = new LinkedList<>();
        for (int[] arr : twoDArray) {
            List<Integer> list = new LinkedList<>();
            for (int a : arr) {
                list.add(a);
            }
            result.add(list);
        }
        return result;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return !isCyclic(numCourses, convert(prerequisites));
    }
    private void createGraph(List<List<Integer>> verts) {
        graph = new HashMap<>();
        for (List<Integer> l : verts) {
            Integer first = l.get(0);
            Integer second = l.get(1);
            Set<Integer> destinations = graph.get(first);
            if (destinations == null) {
                destinations = new HashSet<>();
                destinations.add(second);
                graph.put(first, destinations);
            } else {
                destinations.add(second);
            }
        }
    }
    public boolean isCyclic(int A, List<List<Integer>> verts){
        createGraph(verts);
        for(Integer n : graph.keySet()){
            Set<Integer> isVisited = new HashSet<>();
            Set<Integer> stack = new HashSet<>();
            //System.out.println("\nnew node="+n);
            if(isCyclicUtil(n, isVisited, stack)){
                return true;
            }
        }
        return false;
    }
    private boolean isCyclicUtil(int source, Set<Integer> isVisited, Set<Integer> stack){
        //System.out.print("\nsource="+source);
        if(stack.contains(source)){
            return true;
        }
        if(isVisited.contains(source)){
            return false;
        }
        if(ans.containsKey(source)){
            return ans.get(source);
        }

        isVisited.add(source);
        stack.add(source);
        Set<Integer> adjSet = graph.get(source);
        if(adjSet == null || adjSet.isEmpty()){
            //System.out.println(" no set removing="+source);
            ans.put(source, false);
            stack.remove(source);
            return false;
        }
        //System.out.print(" set=" +adjSet);
        for(Integer adj : adjSet){
            if(isCyclicUtil(adj, isVisited, stack)){
                return true;
            }
        }
        ans.put(source, false);
        //System.out.print("removing=" +source);
        stack.remove(source);
        return false;
    }
}