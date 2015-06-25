n = int(raw_input())
grid = []
for x in xrange(n):
    grid.append(list(raw_input()))


configs = []

for i in xrange(len(grid)):
    cand = []
    for j in xrange(len(grid[0])):
        if grid[i][j] == '1':
            cand.append(j)
    if len(cand) > 0: 
        configs.append(cand)
configs.append([])
def check(grid, config):
    rows = 0
    config = set(config)
    for i in xrange(len(grid)):
        fault = False
        for j in xrange(len(grid[0])):
            if j not in config and grid[i][j] == '1':
                fault = True
            elif j in config:
                if grid[i][j] == '0':
                    fault = True
        if not fault:
            rows += 1
    return rows


def evaluate(configs, grid):
    answer = 0
    for config in configs:
        answer = max(check(grid, config), answer)
    return answer


print evaluate(configs, grid)
