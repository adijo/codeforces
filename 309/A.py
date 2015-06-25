s = raw_input()

tot = set()

for i in xrange(len(s)):
    
    for j in xrange(97, 97 + 26):
        # add before
        before = s[:i]
        after = s[i:]
        
        tot.add(before + chr(j) + after)
        before = s[:i + 1]
        after = s[i + 1:]
        tot.add(before + chr(j) + after)

print len(tot)

