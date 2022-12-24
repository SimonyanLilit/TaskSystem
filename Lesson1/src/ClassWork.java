public class ClassWork {
    public static void main(String[] args) {
        int[] arr = {155, 24, 68, 9, 122, 0, 98, 76};
/*
        for (int a = 0; a < arr.length ; a++) {
            for (int i = 0; i < arr[a].length; i++) {
                System.out.print(arr[a][i]+" ");

            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               if(j+i<=arr.length-1)
                   System.out.print(arr[i][j]+" ");
               else System.out.print("  ");
            }
            System.out.println();

            //triangles of matrix



        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j+i>= arr.length-1&&j<=i)
                    System.out.print(arr[i][j]+" ");
                else System.out.print("  ");
            }
            System.out.println();

            //triangles of matrix



        }


        int[] array = {6, 6, 8, -7, -8, 0, 88, -15, 20, 33, 95};

       /* boolean isActive = true;
        int countOfNegative = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                countOfNegative++;
            } else if (array[i] == 0) {
                isActive = false;
                break;
            }
        }
if (!isActive)
    System.out.println("zero");
       else if (countOfNegative % 2 != 0 ) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }*/

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];

        }
        System.out.println(max);
int sec;
        if(arr[0]>arr[1])
            sec=arr[1];
        else sec=arr[0];

        max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                sec=max;
                max = arr[i];
            }else if(arr[i]>sec&&)
                sec=arr[i];
        }
        System.out.println(sec);
    }

}

