 
import java.util.Scanner;




class Stack {
    static  int capacity;
    int size;
    char[] data_array;  
  
    boolean isEmpty()
    {
        return (size==0);
    }
    Stack(int c)
    {
        size=0;
        capacity=c;
        data_array= new char[capacity];
    }
  
    void push(char x)
    {
        if (size == capacity) {
            System.out.println("Stack Overflow");
            return;
        }
        else {
            data_array[size++] = x;
            System.out.println(x + " pushed into stack");
            
        }
    }
  
    void pop()
    {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        {
           size--;
        }
    }
  
    char top()
    {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            
            return data_array[size-1];
        }
    }
     
    
 
}

public class Main {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	char[] brackets=sc.next().toCharArray();
	sc.close();
Stack st=new Stack(10);
for(char i:brackets){
	switch(i) {
	case '{':
	case '(':
	case '[':
		{st.push(i); break;}
	case '}':
	case ')':
	case ']':
	{
		if(st.isEmpty()|| !is_pair(st.top(),i)) {System.out.println("not balansed!");
		return;}
		st.pop();
	}
	}
}
if(st.isEmpty())
	System.out.println("balansed!");
	}
	static boolean is_pair(char top,char temp) {
		switch(top) {
		case '{':
			return temp=='}';
		case '(':
			return temp==')';
		case '[':
			return temp==']';
		 default: return false;
		}
	}
	
	
	
	
}