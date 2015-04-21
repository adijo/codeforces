n, m = map(int, raw_input().split())

val = n - m
maximum = (val * (val + 1)) / 2

minimum = None
if n % m == 0:
	val = n / m
	minimum = m * ((val * (val - 1)) / 2)
else:
	modulus = n % m
	val = n / m
	minimum = (m - 1 * ((val * (val + 1)) / 2)) + ((modulus * (modulus - 1)) / 2)

print minimum, maximum
