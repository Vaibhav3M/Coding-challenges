


def fibonacci_memo(n, memo = {0:0, 1:0, 2:1}):

    if n in memo:
        return memo[n]
    else:
        memo[n] = fibonacci_memo(n-1, memo) + fibonacci_memo(n-2, memo)
        return memo[n]


def fibonacci_iter(n):

    last = 0
    secondLast = 1
    counter = 2

    while(counter <= n):
        currFibbo = last + secondLast
        last = secondLast
        secondLast = currFibbo
        counter += 1

    return secondLast if n > 1 else last




print(fibonacci_memo(10))

print(fibonacci_iter(10))
