class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //solution
        //shifting using swapping when nums2 array elements needs to be inserted
        //convert to arraylist
        //temp array
        //example 4,6,7,0,0,0 and 1,2,5 => 1,2,4,5,6,7        
        if(nums2.length==0){
            return;
        }
        int i = nums1.length-1;
        int j = nums2.length-1;
        int valueIndex = m-1;
        while(i>-1 && j>-1){
            if(valueIndex>-1 && nums1[valueIndex]>=nums2[j]){
                nums1[i--] = nums1[valueIndex--];
            } else {
                nums1[i--] = nums2[j--];
            }
        }
        /*while(i>-1){
            nums1[i--] = nums1[valueIndex--];
        } 
        
        while(j>-1){
            nums1[i--] = nums2[j--];
        }*/
    }
}