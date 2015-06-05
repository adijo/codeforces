import itertools

number = list(raw_input())

done = False


def isValid(soln):
    if soln[0] == '0':
        return False
    else:
        return True


def isValidTwo(soln):
    if soln[0] == '0':
        return False
    else:
        return True

for soln in itertools.combinations(number, 3):
    if isValid(soln):
        integer = int(''.join(list(soln)))
        if integer % 8 == 0:
            done = True
            print "YES"
            print integer
            break

for soln in itertools.combinations(number, 2):
    if isValid(soln):
        integer = int(''.join(list(soln)))
        if integer % 8 == 0 and not done:
            done = True
            print "YES"
            print integer
            break

for char in number:
    if int(char) % 8 == 0 and not done:
        print "YES"
        done = True
        print int(char)
        break


if not done:
    print "NO"




