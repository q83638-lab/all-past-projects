a=[]   
letter=[];
inserted=[]
count=[];
track=[];
track1=[];
count1=0
def reset():
    letter=[];
    inserted=[]
    count=[];
    track=[];
    track1=[];
    a=list(p[6:])
    
    
def report(num):
    count1=0
    for x in range(len(a)):
        if (a[x] not in inserted):
            letter.append(a[x])
            inserted.append(a[x])
            count.append(a.count(a[x]))  
            letter.sort()
        if len(letter)>num-1:            
            if(letter[num-1] not in track1):
                track.append(letter[num-1])
                track1.append(letter[num-1])
    count1+=1
    print "".join(track).upper()
p= raw_input()
if "RESET" in p:
    reset()
    print a

report(5)

print track  
        
        

        
        
    
