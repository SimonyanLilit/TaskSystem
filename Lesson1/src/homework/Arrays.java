package homework;
//Task 1
public class Arrays {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 2;

        }
//Task 2
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;

        }
        //Task 4
        int[] array2 = {15, 78, 30, 46, -55, 17, 58, 64, 10};
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] % 5 == 0)
                System.out.print(array2[i] + " ");

        }
        //Task 5
        System.out.println();
        double[] array3={24.78, 48.216, 4.5, 216.5,856.4};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i]>=24.12&& array3[i]<=467.23)
                System.out.print(array3[i] + " ");

        }
        System.out.println();
        //Task 6
        int count=0;
        int[] array4 = {13, 28, 30, 46, -57, 17, -58, 64, 10};
        for (int i = 0; i < array4.length; i++) {
            if (array4[i]%2==0)
                count++;
        }
        System.out.print( "The count of elements that can be divided by 2 is  "+count);

        System.out.println();
//Task 7
        int N=21;
        for (int i = 1; i <=10; i++) {
            System.out.println(N +" x "+i+" = "+N*i);
        }
    }
}