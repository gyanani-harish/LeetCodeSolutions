class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        return targetRange(nums, target);
    }
    private int[] targetRange(int[] nums, int target){
        int index = binarySearch(nums, target);
        if(index == -1){
            return new int[]{-1,-1};
        }
        int l= index - 1;
        int r = index + 1;
        while(l>-1 || r<nums.length){
            boolean found = false;
            if(l>=0 && nums[l]==target){
                found = true;
                l--;
            }
            if(r<nums.length && nums[r]==target){
                found = true;
                r++;
            }
            if(found == false){
                break;
            }
        }
        return new int[]{l+1, r-1};
    }
    private int binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int midIndex = (low+high)/2;
            if(nums[midIndex] == target){
                return midIndex;
            } else if(nums[midIndex]< target){
                low = midIndex + 1;
            } else {
                high = midIndex - 1;
            }
        }
        return -1;
    }
}