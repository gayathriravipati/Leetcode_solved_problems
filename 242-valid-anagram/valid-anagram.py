class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # freq of each char in s
        # freq of each char in t
        # iterate through t_dict and check the value of key in s is matching
        s_dict = {}
        t_dict = {}
        
        for i in range(len(s)):
            if s[i] in s_dict:
                s_dict[s[i]] += 1
            else:
                s_dict[s[i]] = 1
        
        
        for i in range(len(t)):
            if t[i] in t_dict:
                t_dict[t[i]] =  t_dict[t[i]] + 1
            else:
                t_dict[t[i]] = 1
        
        
        for key in t_dict:
            if key in s_dict:
                if t_dict[key] == s_dict[key]:
                    continue
                else:
                    return False
            else:
                return False
            
        for key in s_dict:
            if key in t_dict:
                if s_dict[key] == t_dict[key]:
                    continue
                else:
                    return False
            else:
                return False
            
        
        return True
                
