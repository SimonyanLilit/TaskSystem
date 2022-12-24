public class Main {
    public static void main(String[] args) {
        int t = 0;
        int j = 0;


        int[][] A = {{(t - 1 - j), 0}, {(t * t), (t + 1 + t * j)}, {(-1*t + j), 0}};
        String[][] Astr = {{"(t - 1 - j)", "0"}, {"(t * t)", "(t + 1 + t * j)"}, {"(-t + j)","0"}};
        int[][] Ares = {{(t*t - 2*j)}, {(t*t*t-j*t-j)}, {(-t*t -t-1+j)}};
        String[][] ATstr = new String[2][3];
        int[][] AT = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 3; k++) {
                ATstr[i][k] = Astr[k][i];
            }

        }
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 3; k++) {
                AT[i][k] = A[k][i];
            }

        }
        for (int i = 0; i < ATstr.length; i++) {
            for (int k = 0; k < ATstr[i].length; k++) {
                System.out.print(ATstr[i][k]+" ");

            }
            System.out.println();

        }
        ///68
         matrixMul(AT,A);
        matrixMul(AT,Ares);
    }

    public static void matrixMul(int[][] a, int[][] b) {
        int n, m, i, j, k;
        n=a.length;
        m=b[0].length;


         int[][] C=new int[n][m];


        for ( i = 0; i < n; i++)
        {
            for (j = 0; j < m; j++)
            {
                C[i][j] = 0;
                for (k = 0; k < m; k++)
                {
                    C[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < m; j++)
            {
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }
    }
}
