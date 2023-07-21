
// Bubble sort in Java
import java.util.Scanner;
public class Main {
	static void BubbleSort(int arr[],int n) {
		int i,j;
		int temp;
	for( i=0;i<n-1;i++)
		for( j=0;j<n-i-1;j++)	
			if(arr[j]>arr[j+1]){
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
		}
	
	}
	
//main function
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n;
	do n=sc.nextInt(); while(n<2);
	int[] arr=new int[n];
	for(int i=0;i<n;i++)
		arr[i]=sc.nextInt();
	sc.close();
	
	BubbleSort(arr,n);
	
	for( int i=0;i<n;i++)
		System.out.print(arr[i]+ " ");
	System.out.println();
		}
	}
	