import java.util.Scanner;

public class quesionOne 
{
    public static boolean questionOne(int n, int k, int a) // n is apples k day a is
    {
        if(k == 0) // check if last day remaining and required values are equal
        {
            if(n == a)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(questionOne(n - 3, k - 1, a)) // check if they eat 3 apple
        {
            return questionOne(n - 3, k - 1, a);
        }
        else if(questionOne(n- 2, k - 1, a)) //check if they eat 2 apple
        {
           return questionOne(n- 2, k - 1, a);
        }
        else 
        {
            return false;
        }
       
    }
    
   public static void main(String[] args) 
    {
        System.out.println("input apples, required and day: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int a = scan.nextInt();
        boolean c = questionOne(n,k,a);
        System.out.println(c);
    }
    
}
