package ssl.array;

public class Test {

    public static void main(String[] args) {
        MyArray<Integer> array1 = new MyArray<>();
        for (int i = 0; i < array1.getCapacity(); i++) {
            array1.addLast(i);
        }
        System.out.println(array1);
        array1.addLast(11);
        System.out.println(array1);
    }
}
