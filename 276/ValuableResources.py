n = int(raw_input())

points = []
for i in range(n):
	x, y = map(int, raw_input().split())
	points.append((x, y))

points.sort(key = lambda x : x[0])
max_x = points[len(points) - 1][0]
min_x = points[0][0]

points.sort(key = lambda x : x[1])
max_y = points[len(points) - 1][1]
min_y = points[0][1]


diff_x = max_x - min_x
diff_y = max_y - min_y

print(max(diff_x, diff_y)**2)
