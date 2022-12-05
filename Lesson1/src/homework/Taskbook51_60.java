package homework;

public class Taskbook51_60 {
    public static void main(String[] args) {
        //51
        int num = 479;

        int miavor = 0, tasnavor = 0, haryuravor = 0;
        boolean t;
        miavor = num % 10;
        num /= 10;
        tasnavor = num % 10;
        num /= 10;
        haryuravor = num % 10;
        if (miavor == tasnavor + haryuravor)
            t = true;
        else t = false;
        System.out.println(t);
        //52
        if (miavor == tasnavor || miavor == haryuravor || tasnavor == haryuravor)
            t = true;
        else t = false;
        System.out.println(t);
        //53
        num = 547;
        double numCpy = num;
        int k = 60;
        miavor = num % 10;
        num /= 10;
        tasnavor = num % 10;
        num /= 10;
        haryuravor = num % 10;
        if (numCpy > k)
            System.out.println(numCpy / (miavor + tasnavor + haryuravor));
        else System.out.println(miavor / numCpy);
        //54
        num=126;
        miavor = num % 10;
        num /= 10;
        tasnavor = num % 10;
        num /= 10;
        haryuravor = num % 10;
        int max;
        if(miavor>tasnavor)
            max=miavor;
        else max=tasnavor;
        if (haryuravor>max)
            max=haryuravor;
        System.out.println(max);
        //55
        num=856;
        miavor = num % 10;
        num /= 10;
        tasnavor = num % 10;
        num /= 10;
        haryuravor = num % 10;
        int min;
        if(miavor<tasnavor)
            min=miavor;
        else min=tasnavor;
        if (haryuravor<max)
            min=haryuravor;
        System.out.println(min);
        //56
        num=856;
        numCpy=num;
        miavor = num % 10;
        num /= 10;
        tasnavor = num % 10;
        num /= 10;
        haryuravor = num % 10;
        if (miavor>tasnavor)
            System.out.println((miavor+tasnavor+haryuravor)/numCpy);
        else System.out.println(numCpy);
        //57
        num=856;
        numCpy=num;
        miavor = num % 10;
        num /= 10;
        tasnavor = num % 10;
        num /= 10;
        haryuravor = num % 10;
        if (numCpy>300)
            System.out.println((double)tasnavor/miavor);
        else
            System.out.println((double)haryuravor/miavor);
        //58
        char f;
        num=478;

        miavor = num % 10;
        num /= 10;
        tasnavor = num % 10;
        num /= 10;
        haryuravor = num % 10;
        if (tasnavor+haryuravor<5)
            f='a';
        else f='b';
        System.out.println(f);
        //60
        num=645;

        miavor = num % 10;
        num /= 10;
        tasnavor = num % 10;
        num /= 10;
        haryuravor = num % 10;
      if(miavor>tasnavor&&tasnavor>haryuravor)
          System.out.println(miavor+" "+tasnavor+" "+haryuravor);
      else if (tasnavor>miavor&&miavor>haryuravor)
          System.out.println(tasnavor+" "+miavor+" "+haryuravor);
      else if (miavor>haryuravor&&haryuravor>tasnavor)
          System.out.println(miavor+" "+haryuravor+" "+tasnavor);
      else if (tasnavor>haryuravor&&haryuravor<miavor)
          System.out.println(tasnavor+" "+haryuravor+" "+miavor);
      else if (haryuravor>miavor&&miavor>tasnavor)
          System.out.println(haryuravor+" "+miavor+" "+tasnavor);
      else if (haryuravor>tasnavor&&tasnavor>miavor)
          System.out.println(haryuravor+" "+tasnavor+" "+miavor);

      //59
        //60
        num=645;

        miavor = num % 10;
        num /= 10;
        tasnavor = num % 10;
        num /= 10;
        haryuravor = num % 10;
        if(miavor<tasnavor&&tasnavor<haryuravor)
            System.out.println(miavor+" "+tasnavor+" "+haryuravor);
        else if (tasnavor<miavor&&miavor<haryuravor)
            System.out.println(tasnavor+" "+miavor+" "+haryuravor);
        else if (miavor<haryuravor&&haryuravor<tasnavor)
            System.out.println(miavor+" "+haryuravor+" "+tasnavor);
        else if (tasnavor<haryuravor&&haryuravor<miavor)
            System.out.println(tasnavor+" "+haryuravor+" "+miavor);
        else if (haryuravor<miavor&&miavor<tasnavor)
            System.out.println(haryuravor+" "+miavor+" "+tasnavor);
        else if (haryuravor<tasnavor&&tasnavor<miavor)
            System.out.println(haryuravor+" "+tasnavor+" "+miavor);
    }
}
