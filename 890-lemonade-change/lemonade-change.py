class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five_count = 0
        ten_count = 0
        
        for bill in bills:
            if bill == 5:
                five_count += 1
            elif bill == 10:
                if five_count > 0:
                    five_count -= 1
                    ten_count += 1
                else:
                    return False
            else:  
                if five_count > 0 and ten_count > 0:
                    five_count -= 1
                    ten_count -= 1
                elif five_count >= 3:
                    five_count -= 3
                else:
                    return False
        return True
