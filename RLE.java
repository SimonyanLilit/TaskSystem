import java.util.Scanner;

public class Main {
	private static final char counter = 0;

	static void Compress(char str[]) {
			
	char c=str[0];
	int i , counter=1;
	for(i=1;i<str.length;i++) {
		if(str[i]==c) {counter++;
		}
		
		else  {System.out.print(counter+""+c);counter=1;c=str[i];}
		
	}
	System.out.print(counter+""+c);
	}
	static void Uncompress(char str[]) {
		char counter;
		int i;
		for(i=0;i<str.length-1;i+=2) {
			counter=str[i];
			while(counter>'0') {System.out.print(str[i+1]);counter--;}
		}
	}

	public static void main(String[] args) {
	
	Scanner sc =new Scanner(System.in);
	char[] str =sc.next().toCharArray(); 
	sc.close();
if(str[0]>='1'&&str[0]<='9') Uncompress(str);
else Compress(str);

	}
	
}