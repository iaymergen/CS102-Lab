import java.util.Arrays;
import java.util.Scanner;

public class QuickSortAnalyzer extends SortAnalyzer
{

    @Override
    public Comparable[] sort(Comparable[] arr)
    {
        return sort(arr, 0, arr.length - 1);
    }
    public Comparable[] sort(Comparable[] arr, int smallIndex, int bigIndex)
    {
        if (smallIndex >= bigIndex) 
        {
            return arr;
        }
        Comparable piv = arr[bigIndex];
        int leftP = smallIndex;
        int rightP = bigIndex;

        while (leftP < rightP)
        {
            while (compare(arr[leftP],(piv)) <= 0 && leftP < rightP) 
            {
            leftP++;
            }
            while (compare(arr[rightP],(piv)) >= 0 && leftP < rightP) 
            {
            rightP--;
            }
            change(arr, leftP, rightP);
        }
    
        if(compare(arr[leftP],(arr[bigIndex])) > 0) 
        {
        change(arr, leftP, bigIndex);
        }
        else    
        {
        leftP = bigIndex;
        }
        return arr;
    }
    private static void change(Comparable[] arr, int i1, int i2) 
    {
        Comparable temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    public static void main(String[] args) 
    {
        System.out.println("Please enter your array's lenght");
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt();
        RandomArrayGenerator generator = new RandomArrayGenerator();
        Comparable[] arr = generator.generate(l);
        Comparable[] arr2 = arr;
        
        /*
        for(int i = 0; i < l; i++)
        {
            System.out.println("Please enter number: ");
            int a = scan.nextInt();
            arr[i] = a;
        }
        */
     
        MergeSortAnalyzer m = new MergeSortAnalyzer();
        System.out.println(Arrays.toString(m.sort(arr)));
        System.out.println(m.isSorted(arr));
        System.out.println(m.getNumberOfComparisons());
        
        QuickSortAnalyzer q = new QuickSortAnalyzer();
        System.out.println(Arrays.toString(q.sort(arr2)));
        System.out.println(q.isSorted(arr2));
        System.out.println(q.getNumberOfComparisons());

    }
  
    
    
}
