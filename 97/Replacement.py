n = int(raw_input())
arr = [int(x) for x in raw_input().split()]

def process(arr):
    arr.sort()
    done = set()
    brr = [x for x in arr]
    if len(arr) == 1:
        if arr[0] == 1:
            arr[0] = arr[0] + 1
        else:
            arr[0] = 1
        print arr[0] 
    else:
        flag = False
        for i in range(len(arr)):
            if i == 0:
                if arr[0] > 1:
                    done.add(arr[0])
                    arr[0] = 1
                    flag = True
            elif i == len(arr) - 1:
                if arr[len(arr) - 1] > brr[len(arr) - 2] and arr[len(arr) - 1] not in done:
                    done.add(arr[len(arr) - 1])
                    arr[len(arr) - 1] = brr[len(arr) - 2]
                    flag = True 
            else:
                if arr[i] > brr[i - 1] and arr[i] not in done:
                    done.add(arr[i])
                    arr[i] = brr[i - 1]
                    flag = True

        if not flag:
            arr[len(arr) - 1] = arr[len(arr) - 1] + 1
        print ' '.join([str(x) for x in arr]) 


process(arr)