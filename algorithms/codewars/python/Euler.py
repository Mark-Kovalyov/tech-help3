import math

arr_of_redundant = []

summary = 0

for i in range(1, int(28123/1.5)):
    arr = []
    n = 2
    for j in range(1, int(math.sqrt(i))):
        if i % j == 0:
            arr.append(j)
            if i % n == 0:
                arr.append(i / n)
            n += 1
    if sum(arr) > i:
        arr_of_redundant.append(i)

set_arr = set()

for x in arr_of_redundant:
    for y in arr_of_redundant:
        set_arr.add(x + y)

for i in range(1,28123):
    if i not in set_arr:
        summary += i

print(summary)