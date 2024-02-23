import java.util.ArrayList;
import java.util.Scanner;

public class quesionTwo
{
    public static ArrayList<Integer> maxScore(Game[] games, int maxStorage, int index)
    {
        if(maxStorage <= 0 || index >= games.length) //base case
        {
            return new ArrayList<>();
        }
        if(games[index].storage <= maxStorage) //if storage is enough we decide if we should add or not
        {
            ArrayList<Integer> addTaken = new ArrayList<>();
            ArrayList<Integer> addNotTaken = new ArrayList<>();

            addTaken.add(games[index].score); // check if we add
            addTaken.addAll(maxScore(games, maxStorage - games[index].storage, index + 1)); //check if we add rest of the games

            addNotTaken.addAll(maxScore(games, maxStorage, index + 1)); // check if we do not add the index and add rest of the games
             
            int sum1 = 0;
            int sum2 = 0;
            for(int a = 0; a < addTaken.size(); a++) //find the included sum
            {
                sum1 += addTaken.get(a);
            }
            for(int b = 0; b < addNotTaken.size(); b++) // find the not included sum
            {
                sum2 += addNotTaken.get(b);
            }

            if(sum1 > sum2) // return the larger sum
            {
                return addTaken;
            }
            else
            {
                return addNotTaken;
            }
        }
        else 
        {
            return maxScore(games, maxStorage, index + 1);
        }
    }
     public static void main(String[] args) 
    {
        
        System.out.println("how many games you want to input?");
        Scanner scan = new Scanner(System.in);
        int gameNo = scan.nextInt();
        Game[] games = new Game[gameNo];
        
        for(int i = 0; i < gameNo; i++)
        {
            System.out.println("input game storage and score: ");
            int storage = scan.nextInt();
            int score = scan.nextInt();
            Game g = new Game(storage, score);
            games[i] = g;
        }
        System.out.println("input storage:");
        int maxStorage = scan.nextInt();
        System.out.println(maxScore(games, maxStorage, 0));
        
    }

    
}
