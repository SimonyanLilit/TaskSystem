import java.util.Scanner;
public class Main {
	static void SelectionSort(int arr[],int n) {
	int i, j, temp, min_i=0;
	for(i=0;i<n-1;i++) {
		min_i=i;
	for(j=i+1;j<n;j++)
		if(arr[j]<arr[min_i])
			min_i=j;
	temp=arr[min_i];
	arr[min_i]=arr[i];
	arr[i]=temp;
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
	
	SelectionSort(arr,n);
	
	for( int i=0;i<n;i++)
		System.out.print(arr[i]+ " ");
	System.out.println();
		}
	}
	