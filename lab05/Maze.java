//********************************************************************
//  Maze.java       Author: Lewis/Loftus
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************
import java.awt.Point;
import java.util.ArrayList;

public class Maze
{
   private final int TRIED = 3;
   private final int PATH = 7;

   /*private int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                            {1,0,1,1,1,0,1,1,1,1,0,0,1},
                            {0,0,0,0,1,0,1,0,1,0,1,0,0},
                            {1,1,1,0,1,1,1,0,1,0,1,1,1},
                            {1,0,1,0,0,0,0,1,1,1,0,0,1},
                            {1,0,1,1,1,1,1,1,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,1,1,1,1,1,1,1,1,1,1,1,1}};
         */


   /* test 1
   private int[][] grid ={{1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1}};
   Point i1 = new Point(1,2);
   Point o1 = new Point(2,4);
   */

   /*
   private int[][] grid = {{1, 1, 0, 0, 0, 0},
                              {1, 1, 1, 1, 1, 0},
                              {1, 1, 1, 1, 1, 0},
                              {0, 0, 0, 1, 1, 1}};
   Point i1 = new Point(1,2);
   Point o1 = new Point(2,3);
   */
   

    
    
   /* test 3
   private int[][] grid = {{1, 1, 1, 1, 1, 1},
                           {0, 1, 1, 1, 1, 1},
                           {0, 1, 0, 0, 0, 0},
                           {0, 0, 0, 1, 0, 1}};
   Point i1 = new Point(0,3);
   Point o1 = new Point(3,3);
   */

   /*test 4
   private int[][] grid = {{1, 1, 0, 1, 1, 1},
                           {0, 0, 0, 0, 0, 1},
                           {0, 0, 0, 1, 0, 0},
                           {0, 0, 0, 0, 0, 0},
                           {1, 1, 0, 0, 1, 1}};
   Point i1 = new Point(0,1);
   Point o1 = new Point(0,3);

    Point i2 = new Point(1,5);
    Point o2 = new Point(4,0);
      
    Point i3 = new Point(4,1);
    Point o3 = new Point(4,4);
   */

   private int[][] grid = {{1,0,1,0,0,0},
                           {1,1,1,1,1,0},
                           {1,1,0,0,0,1},
                           {0,0,1,1,0,1}};
   Point i1 = new Point(1,0);
   Point o1 = new Point(3,2);

   Point i2 = new Point(0,2);
   Point o2 = new Point(2,5);


   
   


   



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
               done = traverse (row + 1, column);  // down
            }
            if (!done)
               done = traverse (row, column + 1);  // right
            if (!done)
               done = traverse (row - 1, column);  // up
            if (!done)
               done = traverse (row, column - 1);  // left
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
    ArrayList<Point> inPortals = new ArrayList<>();
    ArrayList<Point> outPortals = new ArrayList<>();
   
    
    
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
    
    public Point teleport(Point p)
    {
      if(check(p))
      {
         int out = inPortals.indexOf(p);
         int x = outPortals.get(out).x;
         int y = outPortals.get(out).y;
         Point a = new Point(x,y);
         return a;
      }
         return null;
    }
    public void createPortal()
    {
        inPortals.add(i1);
        outPortals.add(o1); 
        inPortals.add(i2);
        outPortals.add(o2);

        /* test 4
        inPortals.add(i2);
        inPortals.add(i3);

        outPortals.add(o2);
        outPortals.add(o3);
        */
    }

}
