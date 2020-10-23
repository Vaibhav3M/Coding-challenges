
arr = [3, 5, -4, 8, 11, 1, -1, -16]
sum = 10


def one():
    # simple 2 pointers
    # time n^2
    for i in range(len(arr)):
        for j in range(i+1, len(arr)):
            if arr[i] + arr[j] == sum:
                print("{} {}".format(arr[i], arr[j]))


def two():

    # dict
    # time n space n
    dic = {}

    for i in arr:

        if dic.get(sum - i) != None:
            print("{} {}".format(sum - i, i))
        else:
            dic[i] = 1


def three():

    # sorting, 2 pointers
    # time nlogn 
    sArr = sorted(arr)

    i,j =0, len(arr)-1

    while( i < j ):
        curr = sArr[i] + sArr[j]

        if(curr == sum):
            print("{} {}".format(sArr[i], sArr[j]))
            break
        elif(curr < sum):
            i+=1
        else:
            j-=1



print("Started..!!")

one()
two()
three()