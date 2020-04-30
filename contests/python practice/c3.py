n = int(raw_input())
o = int(raw_input())
p = raw_input().split()
s = raw_input().split()
for e in range(o):
   p[e]=(int)(p[e]);
   s[e]=(int)(s[e]);
sum1=0;
if n==1:   
   p.sort();
   s.sort();
   a=map(max, p, s)   
   for b in range(o):
      a[b]=(int)(a[b]);
   sum1=sum(list(a));    
if n==2:
   p.extend(s);
   p.sort();  
   p.reverse();
   for r in range(o):
      sum1+=(int)(p[r]);  

print(sum1);

   
   

