class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //if stored in stack, how to fetch other than top element greater
        //for each num1, iterate over num2
        //or for each num2, keep num1
        return optimisedSolution(nums1, nums2);
        //return stackBruteForceApproach(nums1, nums2);
    }
    /**
    1. keep nums1 elements in map
    2. access nums2 array and maintain decreasing stack
        1. 1
        3. 4
        4. 4, 2
        
    #dry run 1-nums1 = [4,1,2], nums2 = [1,3,4,2]
        iterating second array-
            #i=0, currentElement=1
            is stack non empty false
            is 1 part of first array yes - stack[1]
            
            #i=1, currentElement = 3
            is stack non empty yes, current>top yes, 
            remove the top, find index which is 1, set ans[1] = 3(current)
            is stack non empty - false
            is 3 part of first array no - stack []
            
            #i=2, current element = 4,
            is stack non empty, false
            is current part of first array, yes - stack[4]
            
            #i=3, current element = 2
            is stack non empty - true and current>top - false
            is current part of first array - yes, stack[4,2]
            
    
    */
    public int[] optimisedSolution(int[] nums1, int[] nums2){
        
        HashMap<Integer, Integer> elementIndexMap = new HashMap<>();
        for(int i = 0;i<nums1.length;i++){
            elementIndexMap.put(nums1[i],i);
        }
        int ans[] = new int[nums1.length];
        for(int i = 0;i<ans.length;i++){
            ans[i] = -1;
        }
        Stack<Integer> decreasingMonoStack = new Stack<>();
        for(int i = 0;i<nums2.length;i++){
            int currentElement = nums2[i];
            while(!decreasingMonoStack.isEmpty() && currentElement>decreasingMonoStack.peek()){
                int popped = decreasingMonoStack.pop();
                Integer index = elementIndexMap.get(popped);
                if(index!=null){
                    ans[index] = currentElement;
                }
                
            }
            if(elementIndexMap.containsKey(currentElement)){
                  decreasingMonoStack.push(currentElement);  
            }
        }
        return ans;
        
    }
    public int[] stackBruteForceApproach(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<nums2.length;i++){
            int size = list.size();
            int top = size>0?list.get(size-1):-1;
            int newElement = nums2[i];
            /*while(size>0 && newElement<top){
                list.remove(size-1);
                size--;
            }*/
            if(newElement>top){          
                list.add(newElement);
            }
        }
        int ans[] = new int[nums1.length];
        for(int i =0;i<nums1.length;i++){
            int element = nums1[i];
            ans[i] = -1;
            for(int j = list.size()-1;j>-1;j--){
                if(list.get(j)==element){
                    if(j==list.size()-1){
                        ans[i] = -1;
                    } else {
                        ans[i] = list.get(j+1);
                    }
                    break;
                }
            }
        }
        return ans;
    }
}