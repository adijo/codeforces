n = int(raw_input())

arr = [int(x) for x in raw_input().split()]

def process(arr):
    faults = 0
    for i in range(len(arr)):
        # cost to get here
        cost = i
        # no of wrong choices at most
        wrong = arr[i] - 1
        faults += (cost * wrong)
        faults += wrong
    faults += len(arr)  
    return faults

print process(arr)


