import java.util.Scanner;
public class Main {
	static void InsertionSort(int arr[],int n) {
		int i,j;
		int key;
	for( i=1;i<n;i++) {
		key=arr[i];
		j=i-1;
		while(j>=0&&arr[j]>key) {
			arr[j+1]=arr[j];
			j=j-1;
			}
		arr[j+1]=key;
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
	
	InsertionSort(arr,n);
	
	for( int i=0;i<n;i++)
		System.out.print(arr[i]+ " ");
	System.out.println();
		}
	}
	