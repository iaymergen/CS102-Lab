package cardgame;

// Player - Simple card game player with name and hand of cards
// author: İpek Güneş Aymergen
// date: 20.02.2022
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors
    public Player( String name)
    {
        // ToDo ++ 
        //creates player with name & empty hand
        this.name = name;
        this.hand = null;
        this.hand = new Cards();
        
    }
    
    // methods
    public String getName()
    {
        return name;
    }
    public Card getCard()
    {
        return this.hand.getTopCard();
    }
    
    public void add( Card c)
    {
        // ToDo ++ 
        //add the card to players hand
        this.hand.addTopCard(c);
    }
    
    public Card playCard()
    {
        // ToDo
        //removes and returns the top card from the players hand
        Card ret = this.hand.getTopCard();
        
        return ret;
    }
    
} // end class Player
