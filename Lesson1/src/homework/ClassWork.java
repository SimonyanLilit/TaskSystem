package homework;

public class ClassWork {
    public static void main(String[] args) {
        int[] array = {45, 784, 68, 78, 97};
        int[] array2 = new int[array.length];
        /*int e;
        for (int i = 0; i < array.length; i++) {
            e = 0;
            while (array[i] != 0) {
                e = e * 10 + array[i] % 10;
                array[i] /= 10;
            }
            array2[i]=e;

        }
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]+ " ");
        }
*/
        //
       /* for (int i = 0; i < array.length; i++) {
            array2[array2.length-1-i]=array[i];


        }
       *\



        */
        int[] arr={4,5,7,5,7};
        int el=0;
        for (int i = 0; i < arr.length; i++) {
        el^=arr[i];
        }
        System.out.println(el);
        //51-70 201-230 +rev with n/2
    }
}
