file=open('DATA31.txt')
def test(n):
    i=2
    while True:
        if i==n:
            return True
        elif n%i==0:
            return False
        i+=1
    
for _ in range(10):
    a=file.readline().strip().split()
    number=int(a[0])**int(a[1])
    if test(number):
        print(number)
    else:
        largestF=0
        
        i=2
        while i<=number/2:
            if test(i):
                
                if number%i==0:
                    count=0
                    
                    factor=i
                    while True:
                        
                        if (not number%factor==0) or factor>number:
                            factor/=i
                            count-=1
                            break
                        
                        count+=1
                        factor*=i
                    if factor*count>largestF:
                        largestF=i*count
            i+=1
        print(largestF)
                    
               
                   