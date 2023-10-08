import java.util.Scanner;
public class Romantointeger
{
    public static void main (String[] args) 
    {
        int num=0,prev=0,ans=0;
        System.out.println("enter a roman number: ");
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        for(int i=str.length()-1;i>=0;i--)
        {
            switch(str.charAt(i))
            {
                case 'I': num=1;break;
                case 'V': num=5;break;
                case 'X': num=10;break;
                case 'l': num=50;break;
                case 'C': num=100;break;
                case 'D': num=500;break;
                case 'M': num=1000;break;
            }
            if(num>=prev)
            {
                ans+=num;
            }
            else{
                ans-=num;
            }
            prev=num;
        }
        System.out.println(ans);
    }
}