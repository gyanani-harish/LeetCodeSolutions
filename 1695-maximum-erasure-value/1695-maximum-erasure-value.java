class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        //create a 10 length array
        //1,1,2,1,1
        //1,0,1,0,0
        //5,2,1,1
        int len = nums.length;
        int[] pSum = new int[len];
        pSum[0] = nums[0];
        for(int i=1;i<len;i++){
            pSum[i] = pSum[i-1]+nums[i];
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int maxSum=0;
        int start=0;
        for(int i =0;i<len;i++){
            Integer index = map.get(nums[i]);
            if(index!=null){
                if(index>=start){
                    int remove = getSum(pSum, start, index);
                    start = index+1;
                    sum = sum - remove;
                } else {
                    map.remove(nums[i]);
                }
            }
            map.put(nums[i], i);
            sum = sum+nums[i];
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
    int getSum(int[] pSum, int start, int end){
        int removal = start == 0? 0 : pSum[start-1];
        return pSum[end] - removal;
    }
}