class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        unique_elements = set()
        for i in range(len(nums)):
            if nums[i] in unique_elements:
                return True
            else:
                unique_elements.add(nums[i])
        return False