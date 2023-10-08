import java.util.Scanner;
import java.util.Arrays;
public class LCP {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of array elements");
        int n= sc.nextInt();
        String[] str=new String[];
        System.out.println("enter the array elements");
        for(int i=0;i<n;i++)
        {
            str[i]=sc.nextLine();
        }
        Arrays.sort(str);
        String str1=str[0];
        String str2=str[str.length-1];
        int index=0;
        while(index<str1.length())
        {
            if(str1.charAt(index)==str2.charAt(index))
            {
                index++;
            }
            else{
                break;
            }
        }
        if(index==0)
        {
            System.out.println(" ");
        }
        else{
            System.out.println(str1.substring(0,index));
        }
    }
}
