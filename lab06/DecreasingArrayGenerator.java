import java.util.Arrays;
import java.util.Random;

public class DecreasingArrayGenerator implements ArrayGenerator

{
 
    @Override
    public Comparable[] generate(int n)
    {
        Comparable[] arr = new Comparable[n];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = n - i;
        }
        return arr;

        /*
        for(int m = 0; m < n; m++)
        {
            Random rand = new Random();
            int r = rand.nextInt(9) + 1;
            arr[m] = r;
        }

        int temp = 0;
        
        for(int i=0; i < arr.length; i++)
        {
            for(int j = 1; j < (arr.length-i); j++)
            {
                if(arr[j-1] < arr[j])
                {
                temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                }
            }
        }
        
        return arr;
        */
    }
    
    public static void main(String[] args) 
    {
        DecreasingArrayGenerator d = new DecreasingArrayGenerator();
        Comparable[] arr = d.generate(9);
        System.out.println(Arrays.toString(arr));
        
    }
}
