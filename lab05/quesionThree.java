import java.util.Scanner;

public class quesionThree 
{
    public static int questionThree(String str1, String str2, int l1, int l2)
    {
        if(l1 == 0) //check lenght
        {
            return l2;
        }
        if(l2 == 0) //check lenght
        {
            return l1;
        }
        if (str1.charAt(l1 - 1) == str2.charAt(l2 - 1)) //check from the last character
        {
            return questionThree(str1, str2, l1 - 1, l2 - 1);
        }

            return 1 + Math.min((Math.min(questionThree(str1, str2, l1, l2 - 1),  questionThree(str1, str2, l1 - 1, l2))), questionThree(str1, str2, l1 - 1,l2 - 1));
        //                               insert                                   remove                                    replace
    }   

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please write the first word: ");
        String str1 = scan.nextLine();
        System.out.println("Plase write the second word: ");
        String str2 = scan.nextLine();

        int c = questionThree(str1, str2, str1.length(), str2.length());
        System.out.println("Minimum moves you need to do is: " + c );
    }
}
