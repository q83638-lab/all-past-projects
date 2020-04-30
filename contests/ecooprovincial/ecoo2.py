a=[]
a.append(1)
for c in range(1,40000):
    a.append(a[c-1]*c)

file=open("DATA31.txt","r")
for x in range(10):
    n=file.readline().split()
    N=(map(long,n))
    K = N[0]
    M = N[1]
    
    current =K**M
    
    for Y in range(1,40000):
        if( a[Y]%current==0):
           
            print Y
            break
