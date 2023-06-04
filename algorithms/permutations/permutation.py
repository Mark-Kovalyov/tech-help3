# from https://qna.habr.com/q/1204528

def partition(n, k, answer):
    if n == 0 :
      yield answer
    cur_len = len(answer)
    if k-cur_len < n:
        for i in range(cur_len):
            answer[i].append(n)
            yield from partition(n-1, k, answer)
            answer[i].pop()
    if cur_len < k:
        answer.append([n])
        yield from partition(n-1,k, answer)
        answer.pop()

for x in partition(4, 2, []):
    print(x)