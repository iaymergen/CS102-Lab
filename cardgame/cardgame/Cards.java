package cardgame;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author: İpek Güneş Aymergen
// date: 20.02.2022
public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    public Cards(boolean fullPack)
    {
        cards = new Card[NOOFCARDSINFULLPACK];
        valid = 0;
        if (fullPack)
        {
            createFullPackOfCards();
            valid = 52;
        }
    }
    public Cards()
    {
        cards = new Card[0];
        valid = 0;
    }
    
    // methods
    public Card getTopCard() //removes & returns top card from collection
    {
        Card tmp;
        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    public int getCard()
    {
        Card last =  cards[cards.length -1];
        return last.getNo();
    }
    
    public boolean addTopCard( Card c) //adds the card to the collection
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned????
            valid++;
            return true;
        }
        return false;
    }
    private void createFullPackOfCards()
    {
        // Todo
        for(int i = 0; i < 52; i++)
        {
            Card added = new Card(i + 1);
            addTopCard(added);
        }
    }
    
    public void shuffle() //randomises order of cards in collection
    {
        // Todo
        for (int i = 0; i < cards.length; i++) // Swap cards
        {
            int j = (int)(Math.random() * cards.length); // random index 
            Card tempCard = cards[i];  
            cards[i] = cards[j];
            cards[j] = tempCard;
        }
    }

    
    
    // For testOnly... remove from production version!
    public void testOnlyPrint()
    {
        for ( int i =0; i < valid; i++)
        {
            System.out.println( cards[i] );
        }
    }
    
} // end class Cards
