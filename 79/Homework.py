import operator
s = raw_input()

k = int(raw_input())

def process(s, k):
    if k >= len(s):
        print 0
        print ""
    else:
        freq = {}
        for char in s:
            if char not in freq:
                freq[char] = 1
            else:
                freq[char] += 1
        sorted_char = sorted(freq.items(), key = operator.itemgetter(1))
        answer = []
        aval = k
        elim = set()
        for i in range(len(sorted_char)):
            char = sorted_char[i][0]
            if aval == 0 or sorted_char[i][1] > aval:
                break
            else:
                aval -= sorted_char[i][1]
                elim.add(sorted_char[i][0])
        for char in s:
            if char not in elim:
                answer.append(char)


        print len(set(answer))
        print ''.join(answer)



process(s, k)