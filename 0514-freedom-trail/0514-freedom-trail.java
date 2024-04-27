class Solution {
    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length();
        int keyLen = key.length();
        int[] curr = new int[ringLen];
        int[] prev = new int[ringLen];
        Arrays.fill(prev, 0);
        
        for (int keyIndex = keyLen - 1; keyIndex >= 0; keyIndex--) {
            Arrays.fill(curr, Integer.MAX_VALUE);
            for (int ringIndex = 0; ringIndex < ringLen; ringIndex++) {
                for (int charIndex = 0; charIndex < ringLen; charIndex++) {
                    if (ring.charAt(charIndex) == key.charAt(keyIndex)) {
                        curr[ringIndex] = Math.min(curr[ringIndex],
                                1 + countSteps(ringIndex, charIndex, ringLen) + prev[charIndex]);
                    }
                }
            }
            prev = curr.clone();
        }
        return prev[0];
    }

    private int countSteps(int curr, int next, int ringLength) {
        int stepsBetween = Math.abs(curr - next);
        int stepsAround = ringLength - stepsBetween;
        return Math.min(stepsBetween, stepsAround);
    }
}