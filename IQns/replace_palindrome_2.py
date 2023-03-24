def findResultantString(s):
    x = s
    c = 0
    p = 0
    n = len(s)
    alpha = [0 for i in range(26)]
    for i in range(n):
        alpha[ord(s[i])-ord('a')]+=1
    for i in range(26):
        if(alpha[i]%2!=0):
            c+=1
    d = c//2
    for i in range(26):
        if(alpha[i]%2!=0 and d>0):
            alpha[i]+=1
            d-=1
    c = c//2
    for i in range(25,-1,-1):
        if(alpha[i]%2!=0 and c>0):
            alpha[i]-=1
            c-=1
    for i in range(26):
        if(alpha[i]%2!=0):
            x = x[:n//2] + chr(i + 97) + x[n//2 + 1 :]
            alpha[i]-=1
        for j in range(alpha[i]//2):
            x = x[:p] + chr(i + 97) + x[p+1:]
            x = x[:n-p-1] + chr(i+97) + x[n-p:]
            p+=1
    return(x)

print(findResultantString("bbcde"))
