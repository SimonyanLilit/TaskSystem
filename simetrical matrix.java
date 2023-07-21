
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n,i,j,i_temp=0,value=1;
	Scanner sc =new Scanner(System.in);
	do{n=sc.nextInt();} while(n<2);
	int[][] x=new int[n][n];
	sc.close();
	 int old_n=n;
	i_temp=0; 
	do {
	for(i=i_temp;i<n;i++) 
		for(j=i_temp;j<n;j++)
if(i==i_temp||i==n-1||j==i_temp||j==n-1)
	x[i][j]=value;
	value++;
	i_temp++; n--;
	} while(n!=0);	

	for(i=0;i<old_n;i++) {
		for(j=0;j<old_n;j++) {
			System.out.print(x[i][j]+" " );
	
		}
		System.out.println();
		
	}
	}
}