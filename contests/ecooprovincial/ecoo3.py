file=open('DATA30.txt')

def test(n):
    for i in range(2,n/2):
        if n%i==0:
            return False
    return True

for i in range(6):
    a=file.readline().strip().split()
    k=int(a[0])
    factors=[1]
    for j in range(2,k+1):
        print(j)
        if test(j):
            if k%j==0:
                if j not in factors:
                    factors.append(j)
                else:
                    factors.remove(j)
                    out=True
                    factor=j
                    while out:
                        factor+=j
                        if j not in factors:
                            factors.append(j)
                            out=False
    factors.sort()
    print(factors)
    print(factors[-1])
    