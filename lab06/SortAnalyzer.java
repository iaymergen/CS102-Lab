public abstract class SortAnalyzer 
{
    private static int numberOfComparisons;
    protected int k = 4;
    
    public int getNumberOfComparisons()
    {
        return this.numberOfComparisons;
    }

    protected static int compare(Comparable o1, Comparable o2)
    {
        numberOfComparisons++;
        if(o1.compareTo(o2) > 0)
        {
            return 1;
        }
        if(o1.compareTo(o2) < 0)
        {
            return -1;
        }
        else return 0;

    }
    public boolean isSorted(Comparable[] arr)
    {
        if(arr.length == 1 || arr.length == 0)
        {
            return true;
        } 
        for(int i = 0; i < arr.length - 1; i++)
        {
            if(arr[i].compareTo(arr[i + 1]) < 0)
            {
                return true;
            }
        }
        return false;

    }
    public abstract Comparable[] sort(Comparable[] arr);
}
