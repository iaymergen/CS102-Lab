package cardgame;

import java.util.ArrayList;
// Cardgame
// author: İpek Güneş Aymergen
// date: 21.02.2022
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players = new ArrayList<Player>();
    ScoreCard         scoreCard = new ScoreCard(4);
    public Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    Player[] winners;
    int playerNo;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        // ToDo
        //Set all players scores to zero
        this.players.add(p1);
        scoreCard.update(0, 0);
        
        this.players.add(p2);
        scoreCard.update(1, 0);
        
        this.players.add(p3);
        scoreCard.update(2, 0);
        
        this.players.add(p4);
        scoreCard.update(3, 0);
        
        fullPack = new Cards(true);
        cardsOnTable = new Cards[52];
        this.fullPack.shuffle(); //Shuffle the pack
        this.cardsOnTable = null; //Create empty piles of cards on table
        this.roundNo = 0;
        this.turnOfPlayer = 0;
        
        for(int t = 0; t < 4; t++) //Deal all the pack between the players
        {
            for(int i = 0; i < 13; i++)
            {
                this.players.get(t).add(this.fullPack.getTopCard());
            }
        }
    }
    
    // methods
    public boolean playTurn( Player p, Card c)
    {
        // Todo
        turnOfPlayer++;
        if(turnOfPlayer == 4)
        {
            roundNo ++;
            turnOfPlayer = 0;
        }
        p.add(c);
        p.playCard();
        return true;
    }
    
    public boolean isTurnOf(Player p)
    {
        // ToDo
        if(players.get(turnOfPlayer) == p)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean isGameOver()
    {
        // ToDo
        if(roundNo == 13)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int getScore(int playerNumber)
    {
        // ToDo?
        return scoreCard.scores[playerNumber];
    }
    
    public String getName( int playerNumber)
    {
        return this.players.get(playerNumber).getName();
    }
    
    public int getRoundNo()
    {
        // ToDo
        return this.roundNo;
    }
    
    public int getTurnOfPlayerNo()
    {
        // ToDo
        return turnOfPlayer;
    }

    
    public Player[] getWinners()
    {
        // ToDo
        for(int i = 0; i < 13; i++)
        {
            winners[i] = players.get(scoreCard.winners[i]);
        }
        return winners;
        
    }
    
    public void showScoreCard()
    {
        System.out.println(scoreCard);

    }
}