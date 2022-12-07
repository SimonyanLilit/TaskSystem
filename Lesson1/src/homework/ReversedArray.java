package homework;

public class ReversedArray {
    public static void main(String[] args) {
        int[] array = {45, 784, 68, 78, 1 };
        int[] array2 = new int[array.length];
        for (int i = 0, j = array.length - 1; i <= array.length / 2; i++, j--) {
            array2[j] = array[i];
            array2[i] = array[j];
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }
}
