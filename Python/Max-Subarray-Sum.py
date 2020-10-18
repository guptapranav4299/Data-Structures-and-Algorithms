# Kadane's Algorithm

#other possibile initilaizations
# arr = [1, 2, 3]
# arr = [-2, -10, -1, -3, -4, -5, -11]
# arr = [2,  0 , 11,14,18, 13,14]
# arr = [2,  2 , 11,14,18, 18,18]

arr = [2, -10, 11, 3, 4, -5, 1]


sumTillNow, maxSum = 0, float('-inf')

for num in arr:
    sumTillNow += num
    maxSum = max(maxSum, sumTillNow)
    if (sumTillNow < 0):
        sumTillNow = 0

print(maxSum)
