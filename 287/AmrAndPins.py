import math

r, x, y, x_p, y_p = map(int, raw_input().split())

dist = math.sqrt((x - x_p)**2 + (y - y_p)**2)

print int(math.ceil(dist / (2 * r)))