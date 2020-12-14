package ssl.array;

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int cap) {
        data = (E[]) new Object[cap];
        size = 0;
    }

    public Array() {
        // 空参默认数组长度为10
        this(10);
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，插入位置非法");
        }
        // 动态扩容
        if (size == data.length) {
            resize(2 * data.length);
        }
        // index位置添加元素
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 扩容函数
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        // 改变指向
        this.data = newData;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败，删除位置非法");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        // 记得更新size
        size--;
        // 泛型指定最后的元素被GC回收
        data[size] = null;
        // 缩容，采用懒缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }


    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，插入位置非法");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
