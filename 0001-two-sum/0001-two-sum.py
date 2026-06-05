class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)

        for i in range (n):
            for j in range (n):
                if nums[i] + nums[j] == target and i != j:
                    return [i ,j]
       
        