package homework;

public class Recursion {
    public static void main(String[] args) {
        Recursion r=new Recursion();
        int n=45;
        System.out.println(r.factorial(n));
        System.out.println(r.fib(n));
       int f=1;
        for (int i = 2; i <=n; i++) {
            f*=i;
        }
        System.out.println(f);

        //fib
        int temp=1;
        for (int i = 3,j=1,k=1; i <= n; i++) {
             temp=j+k;
            j=k;
            k=temp;

        }
        System.out.println(temp);
    }
    public int factorial(int x){
        if(x==0||x==1)
            return 1;
        return x*factorial(x-1);
    }
    public int fib(int x){
        if(x==1||x==2)
            return 1;
        return fib(x-2)+fib(x-1);
    }
}
