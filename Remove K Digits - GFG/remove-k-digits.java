//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private StringBuilder removeLeadingZeros(StringBuilder s){
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                s.deleteCharAt(i);
                i--;
            } else {
                break;
            }
        }
        return s;
    }
    public String removeKdigits(String S, int K) {
        // code here
        String input = S;
        int n = K;
        Stack<Integer> stack = new Stack<>();
        if (n >= input.length()) {
            return "0";
        }
        if (n == 0) {
            return input;
        }

        stack.push(input.charAt(0) - '0');
        for (int i = 1; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            while (n > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                n--;
            }
            stack.push(digit);
        }
        while(!stack.isEmpty() && n>0){
            stack.pop();
            n--;
        }
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            answer.insert(0, digit);
        }
        removeLeadingZeros(answer);
        return answer.length() == 0 ? "0" : answer.toString();
    }
}