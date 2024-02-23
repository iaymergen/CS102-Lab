import java.util.Arrays;
import java.util.Scanner;

public class MergeSortAnalyzer extends SortAnalyzer
{

    @Override
    public Comparable[] sort(Comparable[] arr) 

    {

        

            if (arr.length <= 1)  //base case
            {
                return arr;
            } 
            else 
            {   
                int mid = arr.length / 2; // find the mid
                Comparable[] left = new Comparable[mid];  //create left array
                Comparable[] right = new Comparable[arr.length - left.length];  //create rigth array
            
                for(int i = 0; i < left.length; i++) // create left array
                {
                    left[i] = arr[i];
                }
                for(int j = left.length; j < arr.length; j++) // create right array
                {
                    right[j - left.length] = arr[j];
                }
                
                left = sort(left); // sort the left half recursively
                right = sort(right); // sort the  rigth half recursively
                Comparable[] ret = new Comparable[arr.length];
                ret = mergeSort(left, right); // sort method using parts
                return ret;
            }
            
    }

    public static Comparable[] mergeSort(Comparable[] left, Comparable[] right) {
        
        Comparable[] ret = new Comparable[left.length + right.length];
        
        int leftPoint = 0;
        int rigthPoint = 0;
        int retPoint = 0;

        while (leftPoint < left.length && rigthPoint < right.length)  // chechk if the divided array length is bigger than the check point
        {
            if (compare(left[leftPoint],(right[rigthPoint])) < 0) //if left is smaller
            {
                ret[retPoint++] = left[leftPoint++];
            } 
            else // if right is smaller
            {
                ret[retPoint++] = right[rigthPoint++];
            }
        }
        
        while (leftPoint < left.length || rigthPoint < right.length) 
        {
            if(leftPoint < left.length && rigthPoint < right.length) 
            {
                if(compare(left[leftPoint],(right[rigthPoint])) < 0) //tekrar bak
                {
                    ret[retPoint] = left[leftPoint];
                }
                else 
                {
                    ret[retPoint] = right[rigthPoint];
                }
            }
            else if(leftPoint < left.length) // if left is smaller we increase left check point 1
            {
                ret[retPoint++] = left[leftPoint++];
            }
            else if(rigthPoint < right.length) // if right is smaller we increase right check point 1
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
        RandomArrayGenerator generator = new RandomArrayGenerator();
        Comparable[] arr = generator.generate(l);
        
        MergeSortAnalyzer m = new MergeSortAnalyzer();
        System.out.println(Arrays.toString(m.sort(arr)));
        System.out.println(m.isSorted(arr));
        System.out.println(m.getNumberOfComparisons());
        
    }
    
    
}
