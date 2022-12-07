package homework;

public class CountOfNegatives {
    public static void main(String[] args) {
        int[] array = {6, 6, 8, -7, -8, 0, 88, -15, 20, 33, 95};

        boolean isActive = true;
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
        }
    }
}
