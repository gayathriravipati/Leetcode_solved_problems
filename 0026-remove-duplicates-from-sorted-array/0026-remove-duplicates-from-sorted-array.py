class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        writeIndex = 1
        size = len(nums)
        for i in range(1, size):
            if nums[i-1] != nums[i]:
                nums[writeIndex] = nums[i]  
                writeIndex += 1             

        return writeIndex