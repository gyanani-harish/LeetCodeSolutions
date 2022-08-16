class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int[] arrIndex = new int[26];
        for(int i =0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arrIndex[s.charAt(i)-'a'] = i;
        }
        for(int i = 0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1){
                return arrIndex[s.charAt(i)-'a'];
            }
        }
        return -1;
    }
}