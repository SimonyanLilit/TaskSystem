
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num1,num2,n;
		int[] x1=new int[10];
		int[] y1= new int[10];
	Scanner sc =new Scanner(System.in);
	num1=sc.nextInt();
	num2=sc.nextInt();
	sc.close();
    int n1 = 0;
   int n2 = 0;
   while (num1!= 0)  
   { x1[n1++] = num1 % 10;
   num1 /= 10;
  
   }
   while (num2 != 0) {
y1[n2++] = num2 % 10;
   num2 /= 10;
   }
   if (n1 != n2) { System.out.println("no"); return; }
   n = n1;
		
   int temp;
   int dcounter1 = 0,dcounter2=0;
   boolean isfriendly = true;
  
for (int i = 0; i < n; i++){
    temp = x1[i]; 
    for (int k = 0; k < n; k++)
        if (x1[k] == temp) dcounter1++; 
     for (int j = 0; j < n; j++)
       if (y1[j] == temp) dcounter2++; 
    if (dcounter1 != dcounter2) { isfriendly = false; break; }
}
   
   if (isfriendly) System.out.println("yes" ) ;
  else System.out.println("no");
	}
}