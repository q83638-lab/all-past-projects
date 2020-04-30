file=open("DATA21.txt","r")
for i in range(10):
    N=int(file.readline().strip())
    smallest=0
    ids=[]
    for j in range(N):
        tem=file.readline().strip().split()
        ID=int(tem[0])
        t=int(tem[1])
        for k in range(t):
            if smallest==0:
                smallest=int(tem[k+2])
                if ID not in ids:
                    ids.append(ID)
            else:
                if int(tem[k+2])<smallest:
                    smallest=int(tem[k+2])
                    ids=[ID]
                elif int(tem[k+2])==smallest:
                    if ID not in ids:
                        ids.append(ID)
    ids.sort()
    print smallest," {",
    for j in range(len(ids)-1):
        print ids[j],",",
    print ids[-1],"}"
               