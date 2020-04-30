count1=0
while(count1<5):
    p= raw_input()
    if "RESET" in p:
        a=[]   
        letter=[];
        inserted=[]
        count=[];
        track=[];
        track1=[];           
        a=list(p[6:].upper().strip())
        for x in range(len(a)):
            if (a[x] not in inserted and a[x] in list ("ABCDEFGHIJKLMNOPQRSTUVWXYZ")):
                letter.append(a[x])
                inserted.append(a[x])                
                letter.sort()
                track.append(list(letter))        
    elif "ADD" in p:
        b=list(p[4:].upper().strip()) 
        for x in range(len(b)):
            inserted=list(letter)
            if (b[x] not in inserted and b[x] in list ("ABCDEFGHIJKLMNOPQRSTUVWXYZ")):
                letter.append(b[x])
                inserted.append(b[x])
                letter.sort()
                track.append(list(letter))
        a.extend(b)                 
    elif "DELETE" in p:
        c=list(p[7:].upper())
        inserted=list(letter)
        for x in range(len(c)):
            if(c[x] in inserted and c[x] in list ("ABCDEFGHIJKLMNOPQRSTUVWXYZ")):
                if(a.count(c[x])==1):
                    letter.remove(c[x])
                    inserted=list(letter)
                del a[a.index(c[x])]
            track.append(list(letter))                
    elif "REPORT" in p:
         num=int(p[7:])
         result=[]; 
         lastloc=0                 
         for x in range(len(track)-1):            
            if len(track[x])>num-1 and len(track[x+1])>num-1:            
               if(track[x][num-1] != track[x+1][num-1]):
                    result.append(track[x][num-1])
               lastloc=x+1
         if(len(track[lastloc])>num-1):    
             result.append(track[lastloc][num-1])                    
         print "".join(result).upper() 
         count1+=1   