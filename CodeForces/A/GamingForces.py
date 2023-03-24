def findMinSpells(n, arr):
    count1 = 0
    count2 = 0
    for i in arr:
        if(i==1):
            count1+=1
        else:
            count2+=1
    return (count1//2 + count1%2 + count2)

t = int(input())
for i in range(t):
    n = int(input())
    arr = list(map(int, input().split(" ")))
    print(findMinSpells(n,arr))
