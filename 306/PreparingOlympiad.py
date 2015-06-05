from itertools import chain, combinations
N, L, R, X = map(int, raw_input().split())

probs = [int(x) for x in raw_input().split()]

ctr = 0


def valid(configuration):
    configuration = list(configuration)
    if len(configuration) < 2:
        return False
    configuration.sort()
    acc = sum(configuration)
    if acc >= L and acc <= R and (configuration[len(configuration) - 1] - configuration[0] >= X):
        return True
    else:
        return False
def powerset(iterable):
  xs = list(iterable)
  return chain.from_iterable( combinations(xs,n) for n in range(len(xs)+1) )

for s in powerset(probs):
    if valid(s):
        ctr += 1
print ctr 