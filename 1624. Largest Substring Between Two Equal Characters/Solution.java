public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        //1st case where there is no duplicate then return -1
        //example input - harish, output - aris
        //example input - chandrashekhar, output - 
        //solution - available but n^2, check first char,
            //check from last, if not found then go to next char
            //if found, save diff index with max comparison
            //reduce, return false if all are unique
        int max = -1;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j = s.length()-1;j>i;j--){
                if(s.charAt(j)==c){
                    max = Math.max(Math.abs(j-i-1), max);
                }
            }
        }
        return max;
    }
}
