# Enter your code here. Read input from STDIN. Print output to STDOUT
import re
N=int(input())
l=[]
for i in range(N):
    l.append(input())    
T=int(input())
lt=[]
for i in range(T):
    lt.append(input())
d=dict()
for i in lt:
    for j in l:
        pattern=rf'(?<!\w){i}(?!\w)'
        match=re.findall(pattern,j)
        if i in d:
            d[i].append(len(match))
        else:
            d[i]=[len(match)] 
for k,v in d.items():
    print(sum(v))
