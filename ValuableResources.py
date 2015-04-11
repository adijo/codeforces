from math import fabs

n = int(raw_input())

points = []
for i in range(n):
	x, y = map(int, raw_input().split())
	points.append((x, y))

# sort by x co-ordinates.
points.sort(key = lambda x : x[0])

max_x = points[len(points) - 1][0]
min_x = points[0][0]

# sort by y co-ordinates
points.sort(key = lambda x : x[1])

max_y = points[len(points) - 1][1]
min_y = points[0][1]


print int(fabs(max_x - min_x) * fabs(max_y - min_y))

