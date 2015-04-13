n, m = map(int, raw_input().split())

boys = [int(x) for x in raw_input().split()]
b = boys[0]
boys = set(boys[1:])

girls = [int(x) for x in raw_input().split()]
g = girls[0]
girls = set(girls[1:])
graph = {}

for i in range(n):
	graph["b" + str(i)] = {}

for i in range(m):
	graph["g" + str(i)] = {}

# form links
for i in range(1000):
	boy = i % n
	girl = i % m
	graph["b" + str(boy)]["g" + str(girl)] = 1
	graph["g" + str(girl)]["b" + str(boy)] = 1

happiness = {}

def dfs(curr, visited, graph):
	visited[curr] = True
	happiness[curr] = True

	for neighbour in graph[curr]:
		if not neighbour in visited:
			dfs(neighbour, visited, graph)

for boy in boys:
	happiness["b" + str(boy)] = True
	dfs("b" + str(boy), {}, graph)

for girl in girls:
	happiness["g" + str(girl)] = True
	dfs("g" + str(girl), {}, graph)

flag = True
for i in range(n):
	if "b" + str(i) not in happiness:
		flag = False
		break
for i in range(m):
	if "g" + str(i) not in happiness:
		flag = False
		break
if flag:
	print "Yes"
else:
	print "No"
