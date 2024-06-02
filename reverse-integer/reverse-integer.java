class Solution {
    public int reverse(int x) {
        int reversed = 0;
        int maxPrevious = Integer.MAX_VALUE/10;
        int minPrevious = Integer.MIN_VALUE/10;
        int lastDigitOfMax = 7;
        int lastDigitOfMin = -8;
        while(x!=0){
            int pop = x%10;
            x = x/10;
            if(reversed > maxPrevious || (reversed == maxPrevious && pop>7)){
                return 0;
            } else if(reversed < minPrevious || (reversed == minPrevious && pop<-8)){
                return 0;
            }
            reversed = reversed *10 +pop;
        }
        return reversed;
    }
}