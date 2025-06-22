//corrected my logic using chat-GPT
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        int len = asteroids.length;

        while (idx < len) {
            int n = asteroids[idx];

            if (dq.isEmpty()) {
                dq.addLast(n);
                idx++;
            } else {
                int top = dq.peekLast();

                // Collision only occurs if top is moving right (positive) and n is moving left (negative)
                if (top > 0 && n < 0) {
                     top = Math.abs(top);
                     n = Math.abs(n);

                    if (n > top) {
                        dq.removeLast(); 
                    } else if (n == top) {
                        dq.removeLast(); 
                        idx++;
                    } else {
                        idx++;
                    }
                } else {
                    dq.addLast(n);
                    idx++;
                }
            }
        }

        // Convert deque to array
        int size = dq.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = dq.pollFirst();
        }

        return res;
    }
}
