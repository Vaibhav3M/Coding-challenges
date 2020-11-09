

def product_sum(arr):

    return product_sum_helper(arr,1)


def product_sum_helper(arr, multipler=1):
    # time O(n) - where n is all total elements including subelements n=12
    # space O(d) - max depth or maxmultiplier due to recurssion 

    sum = 0
    for item in arr:
        if type(item) is list:
            sum += product_sum_helper(item, multipler+1)
        else:
            sum += item
    
    return sum * multipler



test_arr = [5,2, [7,-1], 3, [6,[-13,8], 4]]


print(product_sum(test_arr))