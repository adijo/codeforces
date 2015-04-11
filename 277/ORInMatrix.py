m, n = map(int, raw_input().split())

matrix = []
for i in range(m):
	matrix.append(map(int, raw_input().split()))


def fill(answer, i, j, m, n):
	# fill in 0's at ith row and jth column. 
	# if you come across any ones report failure.
	# m --> number of rows
	# n --> number of columns
	for x in range(m):
		if answer[x][j] == 1:
			return False
		else:
			answer[x][j] = 0
	for x in range(n):
		if answer[i][x] == 1:
			return False
		else:
			answer[i][x] = 0
	return True

def seek(answer, i, j, m, n):
	# find a cell that is currently set to None 
	# in the ith row and jth column.
	for x in range(m):
		if answer[x][j] == 1:
			return True
	for x in range(n):
		if answer[i][x] == 1:
			return True

	for x in range(m):
		if answer[x][j] == None:
			answer[x][j] = 1
			return True
	for x in range(n):
		if answer[i][x] == None:
			answer[i][x] = 1
			return True
	return False

def process(matrix, m, n):
	answer = [[None for x in range(len(matrix[0]))] 
	for x in range(len(matrix))]

	# fill in the mandatory zeros.
	for i in range(len(matrix)):
		for j in range(len(matrix[0])):
			if matrix[i][j] == 0:
				res = fill(answer, i, j, m, n)
				if not res:
					return ("NO", None)

	for i in range(len(matrix)):
		for j in range(len(matrix[0])):
			if matrix[i][j] == 1:
				res = seek(answer, i, j, m, n)
				if not res:
					return ("NO", None)
	for i in range(len(matrix)):
		for j in range(len(matrix[0])):
			if answer[i][j] == None:
				answer[i][j] = 0
	return ("YES", answer)

	

res = process(matrix, m, n)
if res[0] == "NO":
	print "NO"
else:
	print "YES"
	for row in res[1]:
		print " ".join(map(str, row))
