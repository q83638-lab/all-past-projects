for q in range(5):
  string =raw_input()
  u=[-1,-1,-1,-1];
  g=[];
  re=[];
  if string.count("(")!=0:
      u[0]=string.index("(")
  if string.count(")")!=0:
      u[1]=string.index(")")
  if string.count("[")!=0:
      u[2]=string.index("[")
  if string.count("]")!=0:
      u[3]=string.index("]")
  for i in range(len(string)):
      if string[i]=="+" or string[i]=="-" or string[i]=="*" or string[i]=="/":
         g.append(i);
  if u[1]==-1 and u[2]==-1 and u[3]==-1:
      for y in range(len(g)):
         if(g[y]>u[0]+3):
             re.append(g[y]+1)
      re.append(len(string)+1)
  elif u[0]==-1 and u[2]==-1 and u[3]==-1:
      re.append(1)
      for h in range(len(g)):
         if(g[h]<(u[1]-3)):
            re.append(g[h]+2)
          
  elif u[0]==-1:
      re.append(u[2]+2)
      for h in range(len(g)):
         if(g[h]>u[2]and g[h]<(u[3]-3)):
            re.append(g[h]+2)
  elif u[2]==-1:
      re.append(1)
      for h in range(len(g)):
         if(g[h]<u[0]-2):
            re.append(g[h]+2)
      if u[0]+1!=1:
         re.append(u[0]+1) 
  elif u[3]==-1:
      re.append(u[1]+2)
      for y in range(len(g)):
         if(g[y]>u[1]+2):
            re.append(g[y]+1)
      if(u[1]+2!=len(string)+1):
         re.append(len(string)+1)

  elif u[1]==-1:
      for y in range(len(g)):
         if(g[y]>u[0]+3 and g[y]<u[3]):
             re.append(g[y]+1)
      re.append(u[3]+1)
  for b in range(len(re)-1):
    print str(re[b]) + ',',
  print re[len(re)-1]       
         
            


    

