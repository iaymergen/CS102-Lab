import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: İpek Güneş Aymergen
// date: 21.02.2022
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        CardGame   game;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 1);
        System.out.println( c);
        System.out.println();
        Card c2 = new Card(2);
        Card c3 = new Card(3);

        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);
        cards.testOnlyPrint();  // remove method after testing!
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update(3, 1);
        scores.update(1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        // ToDo
        p = new Player("p1");
        p.add(c2);
        p.add(c3);
        p.playCard();
        
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");
        Player p4 = new Player("p4");

        // test CardGame class too?
        // Todo
        game = new CardGame(p, p2, p3, p4);
        p.playCard();
        game.playTurn(p, c);
        game.isGameOver();
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        System.out.println( "\nEnd of CardGameTest\n" );
        scan.close();
    }
    
} // end of class CardGameTest
