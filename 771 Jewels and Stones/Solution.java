class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int jewelsLen = jewels.length();
        int stonesLen = stones.length();
        int charArr[] = new int[52];
        final int smallLetterMinus = 'a'-26;
        final int capitalLetterMinus = 'A';
        for(int i=0;i<stonesLen;i++){
            char ch = stones.charAt(i);
            if(ch>='a' && ch<='z'){
                charArr[ch-smallLetterMinus]++;
            } else if(ch>='A' && ch<='Z'){
                charArr[ch-capitalLetterMinus]++;
            }
        }
        int total = 0;
        for(int i=0;i<jewelsLen;i++){
            char ch = jewels.charAt(i);
            if(ch>='a' && ch<='z'){
                total += charArr[ch-smallLetterMinus];
            } else if(ch>='A' && ch<='Z'){
                total += charArr[ch-capitalLetterMinus];
            }
        }
        return total;
    }
}
