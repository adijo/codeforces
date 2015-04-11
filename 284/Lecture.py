n, m = map(int, raw_input().split())

first = {}

for i in range(m):
	one, two = raw_input().split()
	first[one] = two

passage = raw_input().split()

answer = []
for word in passage:
	second_lang = first[word]
	if len(word) == len(second_lang):
		answer.append(word)
	else:
		if len(word) < len(second_lang):
			answer.append(word)
		else:
			answer.append(second_lang)

print ' '.join(answer)

