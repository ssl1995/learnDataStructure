package ssl.栈.练习题.程序员面试指南;

public class ArrayToStack {
    private Integer[] arr;
    private Integer index;

    public ArrayToStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        // index=元数个数=无元数的第一个索引
        index = 0;
    }

    public void push(int obj) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[index++] = obj;
    }

    public Integer pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[--index];
    }


    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return arr[index - 1];
    }
}

