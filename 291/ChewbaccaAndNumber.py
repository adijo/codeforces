n = raw_input()

answer = []
first = False
for char in n:
	if 9 - int(char) < int(char):
		if (9 - int(char)) == 0:
			if not first:
				answer.append(char)
				first = True
			else:
				answer.append(str(9 - int(char)))
		else:
			answer.append(str(9 - int(char)))
			first = True
	else:
		answer.append(char)
		first = True

print ''.join(answer)