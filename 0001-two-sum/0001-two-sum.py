class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index_map = {}
        res = list()  
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in index_map:
                res.append(index_map[diff])
                res.append(i)
                return res
            else:
                index_map[nums[i]] = i
                