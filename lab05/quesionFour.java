import java.awt.Point;
import java.util.ArrayList;

public class quesionFour 
{
    public class Maze
{
   private final int TRIED = 3;
   private final int PATH = 7;

   private int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                            {1,0,1,1,1,0,1,1,1,1,0,0,1},
                            {0,0,0,0,1,0,1,0,1,0,1,0,0},
                            {1,1,1,0,1,1,1,0,1,0,1,1,1},
                            {1,0,1,0,0,0,0,1,1,1,0,0,1},
                            {1,0,1,1,1,1,1,1,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1} };
    

   //-----------------------------------------------------------------
   //  Attempts to recursively traverse the maze. Inserts special
   //  characters indicating locations that have been tried and that
   //  eventually become part of the solution.
   //-----------------------------------------------------------------
   public boolean traverse (int row, int column)
   {
      boolean done = false;
      
      if (valid (row, column))
      {
         grid[row][column] = TRIED;  // this cell has been tried

         if (row == grid.length-1 && column == grid[0].length-1)
            done = true;  // the maze is solved
         else
         {
            if(!done) //teleport
            {
                Point p = new Point(row,column);
                if(check(p))
                {
                    Point next = teleport(p);
                    done = traverse(next.x, next.y);
                }
            }
            if(!done)
            {
                done = traverse (row+1, column);  // down
            }
            if (!done)
               done = traverse (row, column+1);  // right
            if (!done)
               done = traverse (row-1, column);  // up
            if (!done)
               done = traverse (row, column-1);  // left
         }

         if (done)  // this location is part of the final path
            grid[row][column] = PATH;
      }
      
      return done;
   }
   
   //-----------------------------------------------------------------
   //  Determines if a specific location is valid.
   //-----------------------------------------------------------------
   private boolean valid (int row, int column)
   {
      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length)

         //  check if cell is not blocked and not previously tried
         if (grid[row][column] == 1)
            result = true;

      return result;
   }

   //-----------------------------------------------------------------
   //  Returns the maze as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";

      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }

      return result;
   }
}
    
    ArrayList<Point> inPortals = new ArrayList<>();
    Point i1 = new Point(4,1);
    Point i2= new Point(1,2);
    Point i3 = new Point(7,5);

    ArrayList<Point> outPortals = new ArrayList<>();
    Point o1 = new Point(4,3);
    Point o2 = new Point(8,4);
    Point o3 = new Point(5,5);
    

    public boolean check(Point p)
    {
        if(inPortals.contains(p))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    /*
    public boolean samePoint(Point p1, Point p2)
    {
        if(p1.getY() == p2.getX() && p1.getY() == p2.getY())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    */
    public Point teleport(Point p)
    {
        
        if(check(p))
        {
            int out = inPortals.indexOf(p);
            return outPortals.get(out);
        }
        return null;
    }
    public void createPortal()
    {
        inPortals.add(i1);
        inPortals.add(i2);
        inPortals.add(i3);

        outPortals.add(o1);
        outPortals.add(o2);
        outPortals.add(o3);
    }

}
