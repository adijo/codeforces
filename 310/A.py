n = int(raw_input())
s = raw_input()

stack = []
for i in xrange(len(s)):
	if len(stack) == 0:
		stack.append(s[i])
	else:
		if s[i] == '0':
			if stack[len(stack) - 1] == '1':
				stack.pop()
			else:
				stack.append(s[i])
		else:
			if stack[len(stack) - 1] == '0':
				stack.pop()
			else:
				stack.append(s[i])
print len(stack)