//Done with the help of solution and GPT
class Solution {
    public String nearestPalindromic(String n) {
        
        int len = n.length();
        
        boolean is_even = len % 2 == 0;
        
        int mid = is_even ? len / 2 - 1 : len / 2 ;
        
        Long firstHalf = Long.parseLong(n.substring(0, mid + 1));
        
        // List to store possible candidates
        List<Long> possibilities = new ArrayList<>();
        
        possibilities.add(findPalindrome(firstHalf, is_even));               // Original first half
        possibilities.add(findPalindrome(firstHalf - 1, is_even));           // First half - 1
        possibilities.add(findPalindrome(firstHalf + 1, is_even));           // First half + 1
        possibilities.add((long) Math.pow(10, len - 1) - 1);                 // 999... (one less digit)
        possibilities.add((long) Math.pow(10, len) + 1);                     // 100... (one more digit)
        
        Long num = Long.parseLong(n);
        Long diff = Long.MAX_VALUE;
        Long closest = 0L;
        
        // Check each possible palindrome
        for (Long candidate : possibilities) {
            if (candidate.equals(num)) continue;
            
            long currentDiff = Math.abs(num - candidate);
            
            // Update closest palindrome based on difference and lexicographical order
            if (currentDiff < diff || (currentDiff == diff && candidate < closest)) {
                closest = candidate;
                diff = currentDiff;
            }
        }
        
        // Convert closest to String
        return Long.toString(closest);
    }
    
    // Helper function to create palindrome from left half
    public Long findPalindrome(Long left, boolean isEven) {
        Long res = left;
        if (!isEven) {
            left = left / 10;  
        }
        
        // Mirror the first half to form a palindrome
        while (left > 0) {
            res = res * 10 + left % 10;
            left = left / 10;
        }
        
        return res;
    }
}
