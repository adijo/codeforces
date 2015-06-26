# This was fun.

from fractions import Fraction

n = int(raw_input())

arr = [int(x) for x in raw_input().split()]

first = Fraction(sum(arr), len(arr))

arr = sorted(arr, reverse = True)
acc = 0
tot = 0
for i in xrange(len(arr)):
    tot += 2 * (acc - (i * arr[i]))
    acc += arr[i]

two = Fraction(tot, len(arr) * (len(arr) - 1))

second = two * (len(arr) - 1)

answer = first + second

print answer.numerator, answer.denominator