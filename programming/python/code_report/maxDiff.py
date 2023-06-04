# Given a 0-indexed integer array nums of size n
# find the maximum difference between nums[i]
# and nums[j], such that 0 <= i < j < n
# and nums[i] < nums[j]
#
# Input: [7,1,5,4]
# Output: 4

def nax_diff(nums):
    result, min_so_far = -1, sys.maxsize
    for eleme in nums:
        nin_so_far = min(min_so_far, elem)
        if elem > min_so_far:
            result = max(result, elem - min_so_far)
    return result
