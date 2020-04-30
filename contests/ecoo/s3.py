file=open("DATA31.txt","r")
for p in range (10):
    a=[];
    test=[]
    output=""
    temp=[]
    ans=[]
    loc = []
    n=file.readline().split()
    a=(map(int,n))
    match = True
    
    x=a[1]
    y=a[2]
    z=a[3]
    for i in range (a[0]):
        test.append(file.readline().strip());
    file.readline()
    for i in range (a[0]):
        ans.append(file.readline().strip());
    'print test,ans'
    file.readline()
    for i in range (a[0]): 
        temp=list(test[i])
        temp=map(int,temp)
        for t in range (len(temp)): 
            if temp[t]==0:
                output+=str(z)
            elif temp[t]%2!=0:
                if temp[t]>y:
                  output+=str(temp[t]-y)
                else :
                    output+="0"
            else:
                output+=str(temp[t]+x)
        
        if output != ans[i]:
            match = False
            loc.append(i+1)               
        
        output = ""
    if match == False:
        print "FAIL: ",
        for b in range(len(loc)-1):
                print str(loc[b]) + ',',
        print loc[len(loc)-1] 
    
    else:
        print "MATCH"
        