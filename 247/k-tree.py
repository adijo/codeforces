def k_tree_basic(n, k):
    D = [0] * (n + 1)
    D[0] = 1
    D[1] = 1
    D[2] = 2
    for i in range(3, n + 1):
        for j in range(1, k + 1):
            if i - j >= 0: D[i] += D[i - j]
    return D


def k_tree(n, k, d):
    abnormal = [0] * (n + 1)
    if d < 1: abnormal[0] = 1
    else: abnormal[0] = 0
    if n == 0: return abnormal[0]
    if d <= 1: abnormal[1] = 1
    else: abnormal[1] = 0
    if n == 1: return abnormal[1]
    if d == 1: abnormal[2] = 2
    elif d == 2: abnormal[2]  = 1
    elif d == 0: abnormal[2] = 2
    else: abnormal[2] = 0
    normal = k_tree_basic(n, k)
    for i in range(3, n + 1):
        for j in range(1, k + 1):
            if j >= d and i - j >= 0: abnormal[i] += normal[i - j]
            elif (i - j) >= 0: abnormal[i] += abnormal[i - j]
    return abnormal[n] % 1000000007

inp = raw_input().split()
n, k, d = int(inp[0]), int(inp[1]), int(inp[2])
print k_tree(n, k, d)
