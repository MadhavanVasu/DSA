class Solution:
    def maxSubArray(self, nums):
        s=0
        high=nums[0]
        start = 0
        end = 0
        f = 0
        for i in range(len(nums)):
            s+=nums[i]
            if s>high:
                high=s
                end = i
                if(f==1):
                    start = i
                    f = 0
            if s<0:
                s=0
                f = 1
        print(nums[start:end+1])
        return high

obj = Solution()
print(obj.maxSubArray([-4,-3,-2]))
