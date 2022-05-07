class Solution {
    val adj: MutableList<MutableList<Int>> = mutableListOf(mutableListOf<Int>())
    
    fun createGraph(n: Int){
        for(i in 0..n-1){
            adj.add(mutableListOf())
        }
    }
    
    fun addEdge(v: Int, w: Int){
        adj[v].add(w);
    }
    
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val graph = Solution()
        graph.createGraph(n)
        for(edge in edges){
            graph.addEdge(edge[0], edge[1]);
            graph.addEdge(edge[1], edge[0]);
        }
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(source)
        val isVisited = Array(n, { i->false})
        while(!queue.isEmpty()){
            val s = queue.poll()
            if(s == destination){
                return true
            }
            val iter = graph.adj[s].listIterator()
            while(iter.hasNext()){
                val node = iter.next()
                if(!isVisited[node]){
                    isVisited[node] = true
                    queue.add(node)
                }
            }
        }
        return false
    }
}