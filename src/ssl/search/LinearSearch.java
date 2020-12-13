package ssl.search;


import ssl.utils.Student;

public class LinearSearch {
    // 构造器私有化
    private LinearSearch() {
    }

    /**
     * 线性查找1：不使用泛型
     */
    public static int linearSearch1(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 线性查找2：使用泛型
     */
    public static <E> int linearSearch2(E[] data, E targer) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(targer)) {
                return i;
            }
        }
        return -1;
    }

    // 测试
    public static void main(String[] args) {
        // 使用泛型就要使用包装类，比较实用equals
        Integer[] data = new Integer[]{24, 18, 12, 9, 16, 66, 32, 4};
        int res1 = linearSearch2(data, 16);
        System.out.println(res1);
        // 自定义类重写equals
        Student[] students = {new Student("a"), new Student("b")};
        Student target = new Student("b");
        int res2 = linearSearch2(students, target);
        System.out.println(res2);
    }
}
