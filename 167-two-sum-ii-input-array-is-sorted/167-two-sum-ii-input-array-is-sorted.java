class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i =0;i<numbers.length-1;i++){
            int result = binarySearch(numbers, target-numbers[i], i);
            if(result != -1){
                return new int[]{i+1, result+1};
            }
        }
        return new int[]{-1,-1};
    }
    int binarySearch(int[] nums, int target, int exception){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                if(mid == exception){
                    if(mid-1>-1 && nums[mid-1] == target){
                        return mid-1;
                    } else if(mid+1<nums.length){
                        return mid+1;
                    }
                } else {
                    return mid;
                }
            } else if(nums[mid]>target){
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}