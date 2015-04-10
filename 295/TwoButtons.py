import Queue

n, m = map(int, raw_input().split())


def bfs(n, m):
	q = Queue.Queue()
	q.put((n, 0))
	visited = {}
	visited[n] = True
	while not q.empty():
		top = q.get()
		elem = top[0]
		visited[elem] = True
		if elem == m:
			return top[1]
		if elem - 1 > 0 and elem - 1 not in visited:
			q.put((elem - 1, top[1] + 1))
		if 2 * elem not in visited and elem <= m:
			q.put((2 * elem, top[1] + 1))



print bfs(n, m)