class Solution {
    public String decodeString(String input) {
        /*
        its kind of executing a for loop instruction, which can have multiple nested loops inside
        1. either simplify it by copying instruction and then follow
        2. or execute as you read but start from inner ones
        
        
        */
         Stack<Character> stack = new Stack<>();
        //loop over chars
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ']') {
                //find ']' char to process
                stackPushAll(stack, repeatChars(stack, input));
            } else {
                //else push to stack
                stack.push(input.charAt(i));
            }
        }
        return convertStackToString(stack);
    }
    private String convertStackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    void stackPushAll(Stack<Character> stack, String toAdd) {
        for (int i = 0; i < toAdd.length(); i++) {
            stack.push(toAdd.charAt(i));
        }
    }

    String repeatChars(Stack<Character> stack, String input) {
        StringBuilder chars = findBetweenBrackets(stack);
        int num = getNumber(stack);
        return new String(new char[num]).replace("\0", chars);
    }

    private int getNumber(Stack<Character> stack) {
        int num = 0;
        int base = 1;
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
            num = (stack.pop()-'0') * base + num;
            base = base * 10;
        }
        return num;
    }

    private StringBuilder findBetweenBrackets(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();
        while (stack.peek() != '[') {
            result.append(stack.pop());
        }
        stack.pop();//removing start bracket
        return result.reverse();
    }
}