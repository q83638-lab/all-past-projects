file=open("DATA40.txt","r")
fibo_seq=[1,1,2,3,5,8,13,21]

def fibo(num):
    if len(fibo_seq)>=num-1:
        return fibo
    if len(fibo_seq)>=num-2:
        a=fibo_seq[num-3]
        b=fibo_seq[num-2]
    elif len(fibo_seq)>=num-3:
        a=fibo_seq[num-3]
        b=fibo(num-1)
    else:
        a=fibo(num-2)
        b=fibo(num-1)
    ans=a+b
    if ans not in fibo_seq:
        fibo_seq.append(ans)
    return ans
    
for i in range(10):
    tem=file.readline().strip().split()
    x=tem[0]
    y=tem[1]
    pos=[0,0,0,0]
    if x<0:
        pos[2]=-x
    else:
        pos[0]=x
    if y<0:
        pos[1]=-y
    else:
        pos[3]=y
    dir=[1,1,0,0]   
    idx=1
    dir_idx=2
    while True:
        match=True
        for j in range(4):
            if dir[j]<pos[j]:
                match=False
        if match==True:
            break
        else:
            idx+=1
            dir[dir_idx]+=fibo(idx)
            if dir_idx==3:
                dir_idx=0
            else:
                dir_idx+=1
    print(idx)