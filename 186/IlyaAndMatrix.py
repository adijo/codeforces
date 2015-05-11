from math import sqrt, log
n = int(raw_input())

arr = [int(x) for x in raw_input().split()]

def process(n, arr):
    arr.sort()
    arr = arr[::-1]
    acc = 0
    while len(arr) > 0:
        acc += sum(arr)
        arr = arr[: len(arr) / 4]
    return acc

print process(n, arr)