def solve(n):
	if n == "4":
		return 1
	elif n == "7":
		return 2
	else:
		number = str(n)
		index = 0
		for i in range(1, len(number)):
			index += 2**i
		
		if number[0] == "7":
			index += smallest(number, 1, 0)
		index += smallest(number, 1, 1)
		return index

def smallest(number, i, mode):

	if i == len(number) - 1:
		if mode == 0:
			return 2
		else:
			if number[i] == "7":
				return 2
			else:
				return 1
	else:
		if mode == 0:
			return 2 * smallest(number, i + 1, 0)
		else:
			if number[i] == "7":
				return smallest(number, i + 1, 0) + smallest(number, i + 1, 1)
			else:
				return smallest(number, i + 1, 1)


print solve(raw_input())