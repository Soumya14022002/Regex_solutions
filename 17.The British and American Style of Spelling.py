# Enter your code here. Read input from STDIN. Print output to STDOUT
l = ' '.join(input() for _ in range(int(input())))
for i in range(int(input())):
    inp = input()
    print(l.count(inp) + l.count(inp[0:-2]+'se'))
