class Solution {
    fun findCenter(edges: Array<IntArray>): Int {
        val map: MutableMap<Int, Int> = HashMap<Int, Int>()
        val len = edges.size
        for(i in 0 until len){
            val count1: Int? =  map.get(edges[i][0])
            val v = edges[i][0]
            if(count1==null){
                map.put(v, 1)
            } else {
                map.put(v, count1+1)
            }
            val w = edges[i][1]
            val count2: Int? =  map.get(w)
            if(count2==null){
                map.put(w, 1)
            } else {
                map.put(w, count2+1)
            }
            if(i == len-1){
                if(count1!=null && count1+1==len){
                    return v;
                }
                if(count2!=null && count2+1== len){
                    return w;
                }
            }
        }
        return -1
    }
}