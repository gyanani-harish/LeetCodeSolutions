class Solution {
    public int trap(int[] height) {
        // Pointers for the leftmost and rightmost bars in the array.
        int leftPointer = 0, rightPointer = height.length - 1;

        // Initialize variables to keep track of the maximum heights encountered so far.
        int maxLeftHeight = 0, maxRightHeight = 0;
        int trappedWater = 0; // Stores the total amount of trapped rainwater.

        while (leftPointer < rightPointer) {
            // Determine the limiting factor: the lower of the two bars.
            if (height[leftPointer] <= height[rightPointer]) { 
                // Left bar is the limiting factor (shorter or equal to the right).

                // Check if the current left bar is higher than the previous maxLeftHeight.
                if (height[leftPointer] >= maxLeftHeight) {
                    maxLeftHeight = height[leftPointer]; // Update the maxLeftHeight.
                } else {
                    // The current left bar is shorter, so water is trapped.
                    trappedWater += maxLeftHeight - height[leftPointer];
                }
                leftPointer++; // Move the left pointer to the right.
            } else {
                // Right bar is the limiting factor (shorter than the left).
                if (height[rightPointer] >= maxRightHeight) {
                    maxRightHeight = height[rightPointer]; // Update the maxRightHeight.
                } else {
                    // The current right bar is shorter, so water is trapped.
                    trappedWater += maxRightHeight - height[rightPointer];
                }
                rightPointer--; // Move the right pointer to the left.
            }
        }
        return trappedWater; // Return the total amount of trapped water.
    }
}