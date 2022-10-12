class Solution {
    
    /**
    * Example - 5,7,7,8,8,10 - 
    * mid = 0+5/2 = 2, found 7
    * 7<target, go higher side, 
    * now low = 3, high =5, mid = 3+5/2=4
    * 8 is found
    * recurse - 0, 3 for more 8's
    * mid = 0+3/2 = 1
    * 7<8 -> low = 2, high = 3, mid = 2+3/2 = 2
    * 7<8 -> low = 3, high = 3, mid = 3+3/2 = 3
    * 8 == 8
    *
    * Example - 1,2,3,8,8,*8*,8,8,8,10,12
    * 
    */
     public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            Set<Integer> result = binarySearch(nums, target, 0, nums.length - 1);
            Iterator<Integer> iterator = result.iterator();
            int l = -1;
            int r = -1;

            while (iterator.hasNext()) {
                if (l == -1) {
                    l = iterator.next();
                }
                r = iterator.hasNext() ? iterator.next() : l;
            }
            return new int[]{l, r};
        }
    private Set<Integer> binarySearch(int[] nums, int target, int low, int high) {
            Set<Integer> resultSet = new TreeSet<>();
            while (low <= high) {
                int midIndex = (low + high) / 2;
                if (nums[midIndex] == target) {
                    resultSet.add(midIndex);
                    if (low <= midIndex - 1 && nums[midIndex - 1] == target && (!resultSet.contains(midIndex-1) || !resultSet.contains(low))) {
                        resultSet.addAll(binarySearch(nums, target, low, midIndex - 1));
                    }
                    if (midIndex + 1 <= high && nums[midIndex + 1] == target && (!resultSet.contains(midIndex+1) || !resultSet.contains(high))) {
                        resultSet.addAll(binarySearch(nums, target, midIndex + 1, high));
                    }
                    return resultSet;
                } else if (nums[midIndex] < target) {
                    low = midIndex + 1;
                } else {
                    high = midIndex - 1;
                }
            }
            return resultSet;
        }
}