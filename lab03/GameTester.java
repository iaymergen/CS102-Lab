import java.util.Scanner;

public class GameTester 
{
     public static void main(String[] args) 
    {
        System.out.println("Please input the difficulty level:\n 1- Easy\n 2- Medium\n 3- Hard");
        Scanner scan = new Scanner(System.in);
        int diff = scan.nextInt();   
        Game game = new Game(diff);
        game.play();
        
    } 
    
        
    
}
