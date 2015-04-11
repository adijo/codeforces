n = int(raw_input())

fact = {}

fact[2] = [2]
fact[3] = [3]
fact[4] = [3, 2, 2]
fact[5] = [5]
fact[6] = [5, 3]
fact[7] = [7]
fact[8] = [7, 2, 2, 2]
fact[9] = [3, 3, 7, 2]

num = raw_input()
ans = []
for x in num:
	digit = int(x)
	if digit != 0 and digit != 1:
		transformed = fact[digit]
		ans = ans + transformed

ans.sort()
ans = ans[::-1]
print ''.join([str(x) for x in ans])

