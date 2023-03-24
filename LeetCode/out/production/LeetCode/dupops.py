def dupeOps(arr):
    d = {}
    n = len(arr)
    c = 0
    for i in range(n):
        if(d[arr[i]] not in d):
            d[arr[i]] = 0;
        else:
            c+=1
    return c

arr = [1,2,1,4,2]
print(dupeOps(arr))