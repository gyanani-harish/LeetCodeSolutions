class Solution {
    public int removePalindromeSub(String s) {
        //if odd length, start from middle and expand
        //if even length, pick the mid-1, and mid
        return isPalindrome(s) ? 1 : 2;
    }
    private boolean isPalindrome(String s){
        for(int i=0, j=s.length()-1;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}