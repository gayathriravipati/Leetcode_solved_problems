class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sorted_chars = sorted(s)
        sorted_s_string = ''.join(sorted_chars) 
        
        sorted_chars = sorted(t)
        sorted_t_string = ''.join(sorted_chars) 
        
        if sorted_s_string == sorted_t_string:
            return True
        else:
            return False
