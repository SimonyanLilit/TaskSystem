package homework;

public class BookTasks2 {
    public static void main(String[] args) {
        int a=-6,b=74,c=20,d=9;
        //31
        int max;
        if (a>b)
            max=a;
        else max=b;
        if (c>max)
            max=c;
         if (d>max) {
            max=d;

        }
        System.out.println("max="+max);
        //32
        int min;
        if (a<b)
            min=a;
        else min=b;
        if (c<min)
            min=c;
         if (d<min) {
            min=d;

        }
        System.out.println("min="+min);
        //33
        boolean bool=false;
        if (a==1||b==1||c==1||d==1)
            bool=true;
        System.out.println(bool);
        //34
        bool=false;
        if(a+b==c+d||a+c==d+b||a+d==b+c)
            bool=true;
        System.out.println(bool);
        //35
        bool=false;
        if(a==c+d+b||c==d+b+a||d==b+c+a||b==a+c+d)
            bool=true;
        System.out.println(bool);
        //36
        int count=0;
        if (a%2!=0)count++;
        if (b%2!=0)count++;
        if (c%2!=0)count++;
        if (d%2!=0)count++;
        if (count>=2)
            System.out.println(1);
        else System.out.println(2);
        //37
        bool=false;
        if(a+b==c+d||a+c==d+b||a+d==b+c)
            bool=true;
        System.out.println(bool);
        //38
        bool=false;
        if (a*b==c*d||a*c==d*b||a*d==b*c)
            bool=true;
        System.out.println(bool);
        //39
int[] array={a,b,c,d};
bool=true;
count=0;
while(bool){
    bool=false;
    for (int i = 0; i < array.length-count-1 ; i++) {
        if (array[i]>array[i+1]){
            int temp=array[i];
            array[i]=array[i+1];
            array[i+1]=temp;

        }
         bool=true;
    }
    count++;
}

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();

        //40

        bool=true;
        count=0;
        while(bool){
            bool=false;
            for (int i = 0; i < array.length-count-1 ; i++) {
                if (array[i]<array[i+1]){
                    int temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;

                }
                bool=true;
            }
            count++;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
