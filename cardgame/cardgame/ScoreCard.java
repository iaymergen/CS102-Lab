package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:İpek Güneş Aymergen
// date:19.02.2022
public class ScoreCard
{
    // properties
    int[] scores;
    int[] winners = new int [13];
    int winnersIndex = 0;
    
    
    // constructors
    public ScoreCard(int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
        {
            scores[i] = 0;
        }
    }
    
    // methods
    public int getScore(int playerNo) //returns specified score
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        s += "_____________\n";
        return s;
    }
    public int getMaxNo()
    {
        int max = 0;
        int a = 0;
        for(int i = 0; i < 4; i++)
        {
            if(scores[i] > max)
            {
                max = scores[i];
                a = i;

            }
        }
        winners[winnersIndex] = a; 
        winnersIndex++;
        return max;
        
    }
    
    public int[] getWinners()
    {
        // ToDo 
        return winners;
        
    }
    
} // end class ScoreCard
