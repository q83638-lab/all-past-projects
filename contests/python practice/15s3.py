g = (long)(raw_input())
p = (long)(raw_input())
G = [];
P = []
count = 0
G=range(1,g+1)
P=[int(raw_input())for t in xrange(p)]
for o in xrange(len(P)):            
        if P[o] in G:
            G.pop(G.index(P[o]))
            count = count + 1
        else:    
            s = 0             
            for y in xrange(len(G)-1, -1, -1):                                 
                if  P[o] >= G[y]:            
                    G.pop(y)
                    s = -1                     
                    count = count + 1                    
                    break                         
            if s == 0:
                break                       
print(count)
