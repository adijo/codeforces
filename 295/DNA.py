n = int(raw_input())
s = raw_input()

freq = {}
for char in s:
	if char in freq:
		freq[char] += 1
	else:
		freq[char] = 1
uniq = 0
max_val = max(freq.values())
for char in freq:
	if freq[char] == max_val:
		uniq += 1

print pow(uniq, len(s), 10**9 + 7)