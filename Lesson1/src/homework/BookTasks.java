package homework;

public class BookTasks {
    public static void main(String[] args) {
        //21
int a=45, b=25, c=-78,max;
if(a>b)
    max=a;
else max=b;
if (c>max)
    max=c;
        System.out.println("max value is "+max);
        //22
        int min;
        if(a<b)
            min=a;
        else min=b;
        if (c<min)
            min=c;
        System.out.println("min value is "+min);
        //23
        boolean bool=false;
        if (a==1||b==1||c==1)
            bool=true;
        System.out.println(bool);
        //24
        int count=0;
        bool=false;
        if (a==2) count++;
        if (b==2) count++;
        if (c==2) count++;
        if (count==2)
            bool=true;
            System.out.println(bool);
            //25
        if(c<a+b||b<a+c||a<b+c) System.out.println("y=1");
        else
            System.out.println("y=2");
        //26
        if (a%2==0||b%2==0||c%2==0)
            System.out.println(1);
        else
            System.out.println(2);
        //27
        bool=false;
        if(a==(b+c)/2||b==(a+c)/2||c==(a+b)/2)
            bool=true;
        System.out.println(bool);
        //28
        bool=false;
        if (a*a==b*c||b*b==a*c||c*c==a*b)
            bool=true;
        System.out.println(bool);

        //29

        if(a<b) {
            min = a;
            max=b;
        }
        else {
            min = b;
            max=a;
        }
        if (c<min){

            System.out.print(c+" "+min+" "+max);
        }

        else if (c>max) {
            System.out.print(min+" "+max+" "+c);
        }else  System.out.print(min+" "+c+" "+max);

        System.out.println();
        //30

        if(b<a) {
            min = a;
            max=b;
        }
        else {
            min = b;
            max=a;
        }
        if (min<c){

            System.out.print(c+" "+min+" "+max);
        }

        else if (c<max) {
            System.out.print(min+" "+max+" "+c);
        }else  System.out.print(min+" "+c+" "+max);

        System.out.println();


    }
        }
