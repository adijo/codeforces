n = int(raw_input())

arr = [int(x) for x in raw_input().split()]

diff = len(arr) - arr[0]
if arr[0] == 0:
    diff = 0
flag = True

for i in xrange(1, len(arr)):
    if i % 2 != 0:
        # anticlockwise
        have = arr[i]
        becomes = (arr[i] + (len(arr) - diff)) % len(arr)
        if becomes != i:
            flag = False

    else:
        # clockwise
        becomes = (arr[i] + diff) % len(arr)
        if becomes != i:
            flag = False 

if not flag:
    print "No"
else:
    print "Yes"