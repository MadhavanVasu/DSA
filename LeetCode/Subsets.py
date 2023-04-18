def subsets(nums):
    result = [[]]
    for i in nums:
        temp = []
        for subset in result:
            l = [j for j in subset]
            l.append(i)
            temp.append(l)
        result.extend(temp)
    return result

nums = [1,2,3]
print(subsets(nums))
     
