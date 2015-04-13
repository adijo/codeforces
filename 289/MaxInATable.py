n = int(raw_input())

table = [[0 for x in xrange(n)] for x in xrange(n)]
for i in range(n):
	table[i][0] = 1
	table[0][i] = 1

for i in range(1, n):
	for j in range(1, n):
		table[i][j] = table[i - 1][j] + table[i][j - 1]

print table[n - 1][n - 1	]