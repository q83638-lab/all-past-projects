file=open('DATA22.txt')
for i in range(10):
    hw=[]
    n=int(file.readline().strip())
    weight=0
    def replace(spare,spare_idx):
        for k in xrange(spare_idx,-1,-1):
            if hw[k]<spare:
                s=hw[k]
                hw[k]=spare
                idx=k
                if s!=0:
                    replace(s,idx)
                break
            
    for j in range(n):
        a=file.readline().strip().split()
        if len(hw)>=int(a[0]):
            
            if hw[int(a[0])-1]<float(a[1]):
                spare=hw[int(a[0])-1]
                hw[int(a[0])-1]=float(a[1])
            else:
                spare=float(a[1])
                            
            spare_idx=int(a[0])-1            
            
            if spare>min(hw):        
                replace(spare,spare_idx)
            
        else:
            for k in range(int(a[0])-len(hw)-1):
                hw.append(0.0)
            hw.append(float(a[1]))

    weight=sum(hw)
    weight=round(weight,4)
    
    print(format(weight,'0.4f'))
                