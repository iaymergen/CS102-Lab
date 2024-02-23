import java.util.Arrays;
import java.util.Random;

public class IncreasingArrayGenerator implements ArrayGenerator
{
    @Override
    public Comparable[] generate(int n)
    {
        Comparable[] arr = new Comparable[n];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = i + 1;
        }
        return  arr;

        /*
        for(int m = 0; m < n; m++)
        {
            Random rand = new Random();
            int r = rand.nextInt(9) + 1;
            arr[m] = r;
        }

        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = i + 1; j < arr.length; j++) 
            {
                int tmp = 0;
                if (arr[i] > arr[j]) 
                {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        } 
        return arr;   
        */

        
    }

    public static void main(String[] args) 
    {
        IncreasingArrayGenerator i = new IncreasingArrayGenerator();
        Comparable[] arr = i.generate(8);
        System.out.println(Arrays.toString(arr));
    }
    
    
}
