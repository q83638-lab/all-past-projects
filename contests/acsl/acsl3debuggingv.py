t=raw_input().split(',')
board=[];
board1=[];
import copy
for u in range(len(t)):       
    board1.append(map(int,list('{0:08b}'.format(int(t[u],16)))))
for a in range(5):
    s=raw_input().split(',') 
    x=int(s[0])
    y=int(s[1])
    loc=s[2]
    board=copy.deepcopy(board1)
    for h in range(int(s[3])):
        if board[x-1][y-1]!=0:
            s=board[x-1][y-1]
            if board[x-1][y-1]==4:
                 board[x-1][y-1]=0
            board[x-1][y-1]+=1
            print s
            if s==1:                           
                if loc=='L':
                    loc='B'
                 
                elif loc=='R':
                    loc='A'
                
                elif loc=='A':
                    loc='L'
                  
                elif loc=='B':
                    loc='R'
            if s==3:                                        
                if loc=='L':
                    loc='A'
                 
                elif loc=='R':
                    loc='B'
                
                elif loc=='A':
                    loc='R'
                  
                elif loc=='B':
                    loc='L'
            if s==4:                                         
                if loc=='L':
                    loc='R'
                 
                elif loc=='R':
                    loc='L'
                
                elif loc=='A':
                    loc='B'
                  
                elif loc=='B':
                    loc='A'                            
          
            print "loc changed to:",loc
        if loc=='L':
            if y==8:
             y=1
            else:
             y+=1
        elif loc=='R':
            if y==1:
             y=8
            else:
             y-=1
        elif loc=='A':
            if x==8:
             x=1
            else:
             x+=1
        elif loc=='B':
            if x==1:
             x=8
            else:
             x-=1 
        print loc,x,y
    print str(x)+","+str(y)
         
       