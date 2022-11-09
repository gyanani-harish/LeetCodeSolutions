class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k){
            return "0";
        }
        if(k==0){
            return num;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<num.length();i++){
            int intChar = num.charAt(i)-'0';
            while(!stack.isEmpty() && stack.peek()>intChar && k>0){
                stack.pop();
                k--;
            }
            stack.push(intChar);
        }
        
        if(k>0){
            while(k>0 && !stack.isEmpty()){
                stack.pop();
                k--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        removeLeadingZeros(sb);
        
        return sb.length()==0?"0":sb.toString();
    }
    private void removeLeadingZeros(StringBuilder sb){
        for(int i =0;i<sb.length();i++){
            if(sb.charAt(i)=='0'){
                sb.deleteCharAt(i);
                i--;
            } else {
                break;
            }
        }
    }
}