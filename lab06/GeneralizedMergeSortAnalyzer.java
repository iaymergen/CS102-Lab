import java.util.Arrays;
import java.util.Scanner;


public class GeneralizedMergeSortAnalyzer extends SortAnalyzer
{
   
    @Override
    public Comparable[] sort(Comparable[] arr) 
    {
            if (arr.length <= 1) 
            {
                return arr;
            } 
            else 
            {   
                int mid = arr.length / this.k;
                Comparable[] left = new Comparable[mid]; 
                Comparable[] right = new Comparable[arr.length - left.length]; 
            
                for(int i = 0; i < left.length; i++)
                {
                    left[i] = arr[i];
                }
                for(int j = left.length; j < arr.length; j++)
                {
                    right[j - left.length] = arr[j];
                }
                
                left = sort(left);
                right = sort(right);
                Comparable[] ret = new Comparable[arr.length];
                ret = mergeSort(left, right);
                return ret;
            }
            
    }

    public static Comparable[] mergeSort(Comparable[] left, Comparable[] right) {
        
        Comparable[] ret = new Comparable[left.length + right.length];
        
        int leftPoint = 0;
        int rigthPoint = 0;
        int retPoint = 0;

        while (leftPoint < left.length && rigthPoint < right.length) 
        {
            if (left[leftPoint].compareTo(right[rigthPoint]) < 0) 
            {
                ret[retPoint++] = left[leftPoint++];
            } 
            else 
            {
                ret[retPoint++] = right[rigthPoint++];
            }
        }
        
        while (leftPoint < left.length || rigthPoint < right.length) 
        {
            if(leftPoint < left.length && rigthPoint < right.length)
            {
                if(left[leftPoint].compareTo(right[rigthPoint]) < 0)//tekrar bak
                {
                    ret[retPoint] = left[leftPoint];
                }
                else
                {
                    ret[retPoint] = right[rigthPoint];
                }
            }
            else if(leftPoint < left.length)
            {
                ret[retPoint++] = left[leftPoint++];
            }
            else if(rigthPoint < right.length)
            {
                ret[retPoint++] = right[rigthPoint++];
            }
        }
        return ret;
        
    }

    
    public static void main(String[] args) 
    {
        System.out.println("Please enter your array's lenght");
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt();
        Comparable[] arr = new Comparable[l];
        for(int i = 0; i < l; i++)
        {
            System.out.println("Please enter number: ");
            int a = scan.nextInt();
            arr[i] = a;
        }
     
        MergeSortAnalyzer m = new MergeSortAnalyzer();
        System.out.println(Arrays.toString(m.sort(arr)));
        System.out.println(m.isSorted(arr));
        
    }

}
