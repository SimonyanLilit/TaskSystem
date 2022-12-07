package homework;

public class Matrix {
    public static void main(String[] args) {
        int[][] arr=new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j+i>= arr.length-1&&j<=i)
                    System.out.print(arr[i][j]+" ");
                else System.out.print("  ");
            }
            System.out.println();

        }


        System.out.println("**************************");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j+i>= arr.length-1&&j>=i)
                    System.out.print(arr[i][j]+" ");
                else System.out.print("  ");
            }
            System.out.println();

        }
        System.out.println("**************************");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j+i<= arr.length-1&&j<=i)
                    System.out.print(arr[i][j]+" ");
                else System.out.print("  ");
            }
            System.out.println();

        }
        System.out.println("**************************");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j+i<= arr.length-1&&j>=i)
                    System.out.print(arr[i][j]+" ");
                else System.out.print("  ");
            }
            System.out.println();

        }
    }
}
