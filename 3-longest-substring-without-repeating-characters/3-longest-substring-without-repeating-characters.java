class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] ch = new int[256];
        StringBuilder maxString = new StringBuilder();
        StringBuilder fullMaxString = new StringBuilder();
        int negAdjust = 0;
        for (int i = 0; i < s.length(); i++) {
            int ithChar = s.charAt(i);
            if (ch[ithChar] == 0) {
                ch[ithChar] = i + 1 - negAdjust;
                maxString.append(((char) ithChar));
            } else if (ch[ithChar] > 0) {
                int start = ch[ithChar];
                negAdjust += start;
                reduce(maxString.toString(), ch, start);
                maxString = new StringBuilder(maxString.substring(start));
                maxString.append(((char) ithChar));
                ch[ithChar] = i + 1 - negAdjust;
            }
            if (maxString.length() > fullMaxString.length()) {
                fullMaxString = new StringBuilder(maxString);
            }
        }
        return fullMaxString.length();
    }
    private static void reduce(String s, int[] ch, int neg) {
        for (int i = 0; i < s.length(); i++) {
            int charr = s.charAt(i);
            ch[charr] = ch[charr] - neg;
            ch[charr] = Math.max(ch[charr], 0);
        }
    }
}