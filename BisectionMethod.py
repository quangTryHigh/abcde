import sympy as sp
import math
def bisection_method_dynamic(func, var, a, b, tol=0.00001):
    """Phương pháp chia đôi để tìm nghiệm của phương trình f(x) = 0 trên khoảng [a, b]"""
    if func.subs(var, a) * func.subs(var, b) >= 0:
        raise ValueError("Phương pháp chia đôi không áp dụng được do không có dấu trái ngược.")
    
    iteration = 1
    while (b - a) / 2 > tol:
        c = (a + b) / 2  # Trung điểm
        f_c = func.subs(var, c)

        print(f"Lần lặp {iteration}: khoảng [{a:.6f}, {b:.6f}], trung điểm {c:.6f}")
        iteration += 1
        
        if f_c == 0:  # Nếu tìm thấy nghiệm chính xác
            return c
        elif func.subs(var, a) * f_c < 0:
            b = c  # Nghiệm nằm trong [a, c]
        else:
            a = c  # Nghiệm nằm trong [c, b]

    return (a + b) / 2  # Trả về giá trị gần đúng của nghiệm

# Định nghĩa biến và hàm
x = sp.symbols('x')
f = x + 1 - 2 * sp.sin(math.pi * x)

# Các khoảng cần xét
intervals = [(0, 0.5), (0.5, 1)]

# Tìm nghiệm trên từng khoảng
for interval in intervals:
    print(f"\nTìm nghiệm trên khoảng {interval}:")
    root = bisection_method_dynamic(f, x, interval[0], interval[1])
    print(f"Nghiệm gần đúng: x ≈ {root:.6f}")
