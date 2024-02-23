import java.util.Scanner;
public class HangmanPlay{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the hangman game!\n");
        int gameMode;
        do
        {
            System.out.println("Select a game mode:\n");
            System.out.println("1- TV Characters\n2- Coffee Names\n3- University Names\n4- Celebrities\n5- TV Shows");
            gameMode = scanner.nextInt();
            
        }while(!(gameMode > 0 && gameMode <= 5));
        //starting game
        Hangman game = new Hangman(gameMode);
        System.out.println();
 
        //playing game
        while (!game.isGameOver())
        {
            
            System.out.println("Your word is\n" +game.getKnownSoFar()); 
            System.out.println("Please enter a letter:");//taking char input from user
            char letter = scanner.next().charAt(0);
            if((game.getUsedLetters().indexOf(letter) == -1))
            {
                game.tryThis(letter);
                System.out.println("These letters have been used: " + game.getUsedLetters() +  " \n");
                System.out.println();
            }
            else
            {
                System.out.println("\nThe letter is reentered. Please try another letter.");
                System.out.println("These letters have been used: " + game.getUsedLetters() +  " ");
                System.out.println();
            }
            System.out.println("Word is: " + game.getKnownSoFar());
            
                System.out.println("If you want to guess the word plase press 1\nIf no press 2");
                int guess = scanner.nextInt();
                if(guess == 1)
                {
                    System.out.print("Enter the word:");
                    String guessWord = scanner.next();
                    if(guessWord.equals(game.getSecretWord()))
                    {
                        game.setKnownSoFar(guessWord);
                        game.isGameOver();
                    }
                    else
                    {
                        System.out.println("Wrong guess");
                    }
                }
        }   
        System.out.println();
            if(game.hasLost()) //lost game
            {
                System.out.println("You have lost :( \nBetter luck next time");  
            }
        if(!game.hasLost())//player won
        {
            System.out.println("You found the correct word.\nCONGRATULATIONS!!!");
        }
        scanner.close();
        System.out.println("The word was "+ game.getSecretWord());
        
    }

}