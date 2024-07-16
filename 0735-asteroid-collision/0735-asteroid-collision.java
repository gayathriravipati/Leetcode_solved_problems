class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }

            while (true) {
                int topVal = stack.peek();
                // same direction or topVal is moving left and current asteroid is moving right
                if ((topVal > 0 && asteroids[i] > 0) || (topVal < 0 && asteroids[i] < 0) || (topVal < 0 && asteroids[i] > 0)) {
                    stack.push(asteroids[i]);
                    break;
                }
                // opposite direction and same size
                else if (Math.abs(topVal) == Math.abs(asteroids[i])) {
                    stack.pop();
                    break;
                }
                // opposite direction and topVal is larger
                else if (Math.abs(topVal) > Math.abs(asteroids[i])) {
                    break;
                }
                // opposite direction and topVal is smaller
                else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(asteroids[i]);
                        break;
                    }
                }
            }
        }
        
        // Convert stack to array
        int[] array = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            array[i] = stack.get(i);
        }
        return array;
    }
}
