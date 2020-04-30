file=open('DATA11.txt', 'r') 
for i in range(10):
    tem=file.readline().strip().split()
    T=int(tem[0])
    N=int(tem[1])
    days=0
    for j in range(N):
        a=file.readline().strip()
        if a=="B":
            days+=T
        if days!=0:
            days-=1
    print(days)