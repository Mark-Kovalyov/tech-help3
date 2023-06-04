# Input: arr = [0, 7, 1, 0, 4, 2, 5, 4, 0, 9, 0, 3]
# 
# What: filter series greather than 2
#
# Output: [4, 2, 5, 4]

forward = [all(arr[i:i+N]) for i in range(len(arr)-N)] + [False]*N
print('FORWARD:', list(map(int, forward)))

back = [False]*(N-1) + [all(arr[i-N+1:i+1]) for i in range(N-1, len(arr))]
print('   BACK:', list(map(int, back)))

both = [f or b for f,b in zip(forward, back)]
print('   BOTH:', list(map(int, both)))