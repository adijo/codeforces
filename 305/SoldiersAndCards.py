n = int(raw_input())

k1 = [int(x) for x in raw_input().split()]
k2 = [int(x) for x in raw_input().split()]

visited = set()

turns = 0
impossible = False
won = None
def recurse(a, b):
    global turns
    global won
    global impossible
    tup_a, tup_b = tuple(a), tuple(b)
    if (tup_a, tup_b) in visited:
        impossible = True
    else:
        visited.add((tup_a, tup_b))
        top_a = a.pop()
        top_b = b.pop()
        turns += 1

        if top_a > top_b:
            a = [top_a, top_b] + a
            if len(b) == 0:
                won = 1
            else:
                recurse(a, b)
        else:
            b = [top_b, top_a] + b
            if len(a) == 0:
                won = 2
            else:
                recurse(a, b)
recurse(k1[1:][::-1], k2[1:][::-1])
if impossible:
    print -1
else:
    print turns, won