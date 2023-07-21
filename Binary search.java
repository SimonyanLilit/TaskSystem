
import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int n,i,x;
	Scanner sc =new Scanner(System.in);
	do{System.out.print("n=");
		n=sc.nextInt();} while(n<2);
	int[] nums=new int[n];
	System.out.println("nums:");
	for(i=0;i<n;i++)
		nums[i]=sc.nextInt();
	
	System.out.println("Serching value:");
	x=sc.nextInt();
	sc.close();
	int first=0, last=n-1,mid;
	Arrays.sort(nums);
	System.out.println("Sorted Array:");
	for(i=0;i<n;i++)
		System.out.print(nums[i]+" ");
	System.out.println();
do {
	mid=(first+last)/2;
	if(nums[mid]<x) first=mid+1;
	else if(nums[mid]==x) { System.out.println(x+ " is found on index: " +mid); break;}
	else last=mid-1;
	if(first>last)System.out.println(x+ " is not found");
} while(first<=last);	
	}
}