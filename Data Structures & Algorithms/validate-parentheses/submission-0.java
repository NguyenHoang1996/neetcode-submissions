class Solution {
    public boolean isValid(String s) {
        // Quick check: Odd length strings can never be balanced
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        // Traverse the string character by character
        for (char c : s.toCharArray()) {
            // If it is an opening bracket, push its matching closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            // If it is a closing bracket, check if it matches the top of the stack
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}
