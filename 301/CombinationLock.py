
n = int(raw_input())

a = raw_input()

b = raw_input()

def process(a, b):
	count = 0
	for i in range(len(a)):
		have = int(a[i])
		want = int(b[i])
		if want > have:
			have, want = want, have
		dist = min(have - want, 10 - (have - want))
		count += dist
	return count


print process(a, b)