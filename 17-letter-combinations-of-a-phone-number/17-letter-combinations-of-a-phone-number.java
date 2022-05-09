class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new LinkedList();
        }
        String[] arr = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        List<String> queue = new LinkedList<>();
        queue.add("");
        for(int i =0;i<digits.length();i++){
            String word = arr[digits.charAt(i)-'0'];
            while(queue.get(0).length() == i){
                String front = queue.get(0);
                queue.remove(0);
                for(int j=0;j<word.length();j++){
                    queue.add(front+""+word.charAt(j));
                }
            }
        }
        return queue;
    }
}