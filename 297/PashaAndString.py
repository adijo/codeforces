s = raw_input()
n = int(raw_input())

arr = [int(x) for x in raw_input().split()]


def process(s, arr):
    s = list(s)
    d = {}
    for val in arr:
        if val in d:
            d[val] = (d[val] + 1) % 2
        else:
            d[val] = 1
    newarr = []
    for key in d:
        if d[key] == 1:
            newarr.append(key)
    arr = newarr
    arr.sort()
    if len(arr) == 0:
        return "".join(s)
    lo = arr[0]
    hi = len(s) - lo + 1
    ptr = 0
    while lo <= hi:
        if (ptr + 1) % 2 != 0:
            # switch.
            s[lo - 1], s[hi - 1] = s[hi - 1], s[lo - 1]
        lo += 1
        hi -= 1
        if lo > hi:
            break
        if (ptr + 1) < len(arr) and lo >= arr[ptr + 1]:
            ptr += 1
    return "".join(s)


print process(s, arr)


