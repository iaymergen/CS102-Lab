import java.util.Arrays;
import java.util.Random;

public class RandomArrayGenerator implements ArrayGenerator 
{
    Comparable[] s;
    @Override
    public Comparable[] generate(int n)
    {
        Comparable arr[] = new Comparable[n];
        for(int i = 0; i < n; i++)
        {
            
            Random rand = new Random();
            int r = rand.nextInt(n) + 1;
            arr[i] = r;
        }
        s = arr;
        return arr;
    }
    public static void main(String[] args) 
    {
        RandomArrayGenerator r = new RandomArrayGenerator();
        Comparable[] arr = r.generate(7);
        System.out.println(Arrays.toString(arr));
    }
}
