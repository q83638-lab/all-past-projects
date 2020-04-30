
def fact(no,M):
    f=1
    for i in range(1,no+1):
        f=(f*i)%M
        if f==0:
            break;
    return f;

def find(M):
    low=1
    high=1000000
    ans=low
    while low<=high:
        mid=(low+high)/2
        if fact(mid,M)==0:
            ans=mid
            high=mid-1
        else:
            low=mid+1
    return ans;
file=open("DATA31.txt","r")
for x in range(10):
    n=file.readline().split()
    N=(map(long,n))
    K = N[0]
    M = N[1]
    current =K**M
    print find(current)