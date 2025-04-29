package hus.oop.sorteddatastructure;

public class MySortedArrayList extends MySortedAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public MySortedArrayList() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy kích thước của tập dữ liệu.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        if (checkBoundaries(index, size)) {
            return data[index];
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    /**
     * Thêm phần tử dữ liệu vào danh sách.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value là giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void add(int value) {
        if (size == data.length) {
            allocateMore();
        }
        int i = size - 1;
        while (i >= 0 && data[i] > value) {
            data[i + 1] = data[i];
            i--;
        }
        data[i + 1] = value;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        if (checkBoundaries(index, size)) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }
    }

    @Override
    public int binarySearch(int value) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data[mid] == value) return mid;
            else if (data[mid] < value) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value) != -1;
    }

    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void allocateMore() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public int[] toArray() {
        int[] result = new int[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }
}
