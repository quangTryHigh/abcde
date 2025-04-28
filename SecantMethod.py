import numpy as np

def secant_method(f, x0, x1, tol=0.0001, max_iter=100):
    """
    Giải phương trình f(x) = 0 bằng phương pháp dây cung
    :param f: Hàm cần tìm nghiệm
    :param x0: Giá trị x đầu tiên
    :param x1: Giá trị x thứ hai
    :param tol: Sai số chấp nhận được
    :param max_iter: Số lần lặp tối đa
    :return: Nghiệm gần đúng của phương trình
    """
    print("| k  | x0       | x1       | x2       | f(x2)    |")
    print("|----|----------|----------|----------|----------|")
    
    for i in range(max_iter):
        if abs(f(x1) - f(x0)) < tol:
            print("Chia bởi 0 hoặc gần 0, dừng thuật toán.")
            return None
        
        x2 = x1 - (f(x1) * (x1 - x0) / (f(x1) - f(x0)))
        
        print(f"| {i+1:<2} | {x0:<8.6f} | {x1:<8.6f} | {x2:<8.6f} | {f(x2):<8.6f} |")
        
        if abs(x2 - x1) < tol:
            return x2
        
        x0, x1 = x1, x2
    
    print("Số lần lặp tối đa đã đạt, nghiệm có thể chưa chính xác.")
    return x2

# Phương trình a: x^3 - x - 1 = 0
def func_a(x):
    return x**3 - x - 1

# Phương trình b: e^(2x) - 5 = 0
def func_b(x):
    return np.exp(2*x) - 5

# Giải phương trình a với khoảng (1, 2)
print("\nGiải phương trình a: x^3 - x - 1 = 0")
x0, x1 = 1, 2
root_a = secant_method(func_a, x0, x1)
print(f"Nghiệm gần đúng của phương trình a: {root_a}")

# Giải phương trình b với khoảng (0, 1)
print("\nGiải phương trình b: e^(2x) - 5 = 0")
x0, x1 = 0, 2
root_b = secant_method(func_b, x0, x1)
print(f"Nghiệm gần đúng của phương trình b: {root_b}")