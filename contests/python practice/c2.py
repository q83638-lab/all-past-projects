input=open('input.txt', 'r') 
n = int(input.readline())
p = [int(x) for x in input.readline().split(' ')]
t = [int(x) for x in input.readline().split(' ')]
sum=0;
pcount=0;
tcount=0;
for o in range(n):
   sum+=max(p[o],t[o])
   if p[o]>=t[o]:
      pcount+=1
   elif p[o]<t[o]:
      tcount+=1
if pcount==0:
    small=abs(p[0]-t[0]);
    smallloc=0;
    for s in range(n):        
        if small>abs(p[s]-t[s]):
            small=abs(p[s]-t[s]);
            smallloc=s;
    sum=sum-t[smallloc]+p[smallloc];
    
elif tcount==0:
    small=abs(p[0]-t[0]);
    smallloc=0;
    for i in range(n):        
        if small>abs(p[i]-t[i]):
           small=abs(p[i]-t[i])
           smallloc=i;
    sum=sum-p[smallloc]+t[smallloc];

output=open('output.txt', 'w')
output.write(str(sum))
output.write('\n')
