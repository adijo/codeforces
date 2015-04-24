import math

def nCr(n,r):
    f = math.factorial
    return f(n) / f(r) / f(n-r)

s1 = raw_input()
s2 = raw_input()

plus_want, minus_want = 0, 0
plus_have, minus_have, option = 0, 0, 0

for char in s1:
    if char == '+':
        plus_want += 1
    elif char == '-':
        minus_want += 1

for char in s2:
    if char == '+':
        plus_have += 1
    elif char == '-':
        minus_have += 1
    else:
        option += 1

if plus_have == plus_want and minus_have == minus_want:
    print 1.0
else:
    plus_diff = plus_want - plus_have
    minus_diff = minus_want - minus_have

    if (plus_diff + minus_diff < option) or plus_diff < 0 or minus_diff < 0:
        print 0.0
    else:
        print float((nCr(option, plus_diff))) / (2**option)


