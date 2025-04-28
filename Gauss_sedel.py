import numpy as np

# Ma trận hệ số A và vector b
A = np.array([[10, -2, -2, 0],
              [-1, 11, -1, 3],
              [2, -1, 10, -1],
              [0, 3, -1, 8]], dtype=float)

b = np.array([6, 25, -11, 15], dtype=float)

# Khởi tạo nghiệm ban đầu
x = np.zeros(len(b))

# Số lần lặp
num_iterations = 10

# Phương pháp Gauss-Seidel
for iteration in range(num_iterations):
    x_new = np.copy(x)
    
    for i in range(len(A)):
        sum1 = sum(A[i, j] * x_new[j] for j in range(i))
        sum2 = sum(A[i, j] * x[j] for j in range(i + 1, len(A)))
        x_new[i] = (b[i] - sum1 - sum2) / A[i, i]
    
    x = x_new
    print(f"Iteration {iteration + 1}: {x}")
