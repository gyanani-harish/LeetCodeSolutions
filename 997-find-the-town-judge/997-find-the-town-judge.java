class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1){
            return 1;
        }
        if(trust.length==0 && n>=2){
            return -1;
        }
        //unique nodes
        Map<Integer, Integer> biTrustCountMap = new HashMap<>();
        for(int[] path: trust){
            Integer count = biTrustCountMap.get(path[1]);
            if(count == null){
                count = 0;
            }
            count++;
            biTrustCountMap.put(path[1], count);
        }
    
        for(Map.Entry entry : biTrustCountMap.entrySet()){
            if(((int)entry.getValue())==n-1 && !isThisPersonTrustingAnyone((int)entry.getKey(),trust)){
                return (int)entry.getKey();
            }
        }
        return -1;
    }
    private boolean isThisPersonTrustingAnyone(int candidate, int[][] trust){
        for(int[] path: trust){
            if(path[0]==candidate){
                return true;
            }
        }
        return false;
    }
}