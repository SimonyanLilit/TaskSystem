package homework;

public class BookTasksArrays {
    public static void main(String[] args) {
        int[] array = {8, 6, 10, 7, 3, 0, -5};
        //211
        int count = 0;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                sum += array[i];
                count++;
            }

        }
        System.out.println(sum / count);

        //212
        double q = 1;
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                q *= array[i];
                count++;
            }

        }
        if (count != 0)
            System.out.println(q / count);
        //213
        q = 1;
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                q *= array[i];
                count++;
            }

        }
        if (count != 0)
            System.out.println(q / count);

        //214
        count = 0;
        sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                sum += array[i];
                count++;
            }

        }
        if (count != 0)
            System.out.println(sum / count);
        //215
        sum = 0;
        for (int i = 2; i < array.length; i += 2) {
            sum += array[i];
        }
        System.out.println((int) sum);
        //216
        q = 1;
        for (int i = 2; i < array.length; i += 2) {
            q *= array[i];
        }
        System.out.println((int) q);
        //217
        q = 1;
        for (int i = 1; i < array.length; i += 2) {
            q *= array[i] * array[i];
        }
        System.out.println((int) q);
        //219
        int k = 3;
        count = 0;
        for (int i = k; i < array.length; i += k) {
            count++;
        }
        System.out.println(count);
        //229
        q = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] - i > 0) q *= array[i];
        }
        System.out.println((int) q);
        //244
        q = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 5 == 2) q *= array[i];
        }
        System.out.println((int) q);
        //251
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        System.out.println(max);
        //253
        int min = array[0];
        max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        System.out.println(max + " " + min);
        //255
        int index = 0;
        max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }

        }

        System.out.println(max + index);
        //257
        int[] arr={8, 6, 10, 7, 3, 0, -5,10};
        index=0;
        max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }

        }

        System.out.println(index);
        //270
        index=0;
        min=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<= min) {
                min = arr[i];
                index = i;
            }

        }

        System.out.println(index);
    }
}
