
public class Main {
	

 static String[] recursion(int n, String[] exp) {
	 int i; 
	 boolean foundastr=false,foundpls=false;
	if(n<3)
		return exp;
			 //for( i=0;i<n;i++)
	//System.out.println(exp[i]);
	//System.out.println();
			
	for( i=1;i<n;i+=2) {
	
		if(exp[i]=="*") {foundastr=true; break;}
	}	if(foundastr)  {exp[i-1]=Integer.toString(Integer.valueOf(exp[i-1])*Integer.valueOf(exp[i+1]));
	
	
	}
	else {for( i=1;i<n;i+=2) 
		if(exp[i]=="+") {foundpls=true; break;}
		if(!foundastr&&foundpls)  {exp[i-1]=Integer.toString(Integer.valueOf(exp[i-1])+Integer.valueOf(exp[i+1]));
	
	}}
	
		if(!foundastr&&!foundpls&&exp[1]=="-")   {i=1;exp[i-1]=Integer.toString(Integer.valueOf(exp[i-1])-Integer.valueOf(exp[i+1])); 
	
	}
	do{if(i>=n-2) exp[i]="";
	else{exp[i]=exp[i+2];}i++;
	    
	}while(i<n);
	return recursion(n-=2,exp);	
}
	public static void main(String[] args) {
	
String[] exp= {"8","+","9","*","4","*","2","-","20"};
int n=exp.length;
	 exp=recursion(n,exp);
	
	System.out.println(exp[0]);
	

	}
	
}