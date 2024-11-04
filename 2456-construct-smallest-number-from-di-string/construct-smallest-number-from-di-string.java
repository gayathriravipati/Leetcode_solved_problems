class Solution {
    public static String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        // Iterate through numbers from 1 to n + 1
        for (int i = 0; i <= n; i++) {
            // Push current number (1-based index)
            stack.push(i + 1);

            // If we reach end or find an 'I' in the pattern, start popping from the stack
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }

}