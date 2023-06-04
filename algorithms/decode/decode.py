numbers = [1, 2, 3]
letters = ['c', 'a', 't']
zipped = zip(numbers, letters)


line = ['t', 'c', 'a']
pos = [2,0,1]
print(''.join(line[i] for i in pos))
