class Solution {
    public void moveZeroes(int[] nums) {
        //with counting zeros
        withCountingZeros(nums);
    }
    private void withCountingZeros(int []nums){
        //[0,1,0,3,12]
        //[1,0,0,3,12]
        /*int count = 0;
        List<Integer> zeroPos = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                zeroPos.add(i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0 && i>zeroPos.get(0)){
                swap(nums, i, zeroPos.get(0));
            }
        }*/
        
        //[0,0,1,0,3,12]
        //[1,0,0,0,3,12]
        //[1,3,0,0,0,12]
        //[1,3,12,0,0,0]
        
        //[0,1,0,3,12]
        //[1,0,0,3,12]
        //[1,3,0,0,12]
        //[1,3,12,0,0]
        
        int zeroPos = -1;
        int firstZeroPos = -1;
        int nonZeroPos = -1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                if(firstZeroPos == -1){
                    firstZeroPos = i;
                }
                zeroPos = i;
            } else if(nums[i]!=0){
                nonZeroPos = i;
            }
            if(zeroPos !=-1 && nonZeroPos!=-1 && firstZeroPos<nonZeroPos){
                swap(nums, firstZeroPos, nonZeroPos);
                //return;
                //int temp = firstZeroPos;
                //firstZeroPos = nonZeroPos;
                nonZeroPos = -1;
                if(firstZeroPos+1<nums.length){
                    if(nums[firstZeroPos+1]==0){
                        firstZeroPos++;
                    } else if(firstZeroPos<zeroPos){
                        firstZeroPos = zeroPos;
                    } else {
                        firstZeroPos = -1;
                    }
                }
            }
        }
    }
    private void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}