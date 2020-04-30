k =input()
u=[0];
for q in range(k):
   in1 =(int)(raw_input())
   if in1!=0:
      u.append(in1)
   else:
      u.pop();
print(sum(u));