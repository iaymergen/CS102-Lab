import java.util.Random;

public class Hangman {
    private StringBuffer secretWord = new StringBuffer();
    private StringBuffer allLetters;
    private StringBuffer usedLetters = new StringBuffer();
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;
    private StringBuffer knownSoFar = new StringBuffer();
    private String[] allWords = {};
    private String[] tvCharacters = {"spongebob", "patrick", "pepe", "sandy", "squidward", "gary", "rick", 
        "morty", "bojack", "plankton", "winnie", "snoopy", "jerry", "tom", "fineas", "batman", "superman", "loki",    
        "ironman", "thor", "wolverine", "deadpool", "valkyrie", "daredevil", "aquaman", "shazam", "flash", "joker"};
    private String[] coffeeNames = {"americano", "latte", "espresso", "mocha", "affogato", "cortado", "frappe",
        "cappucino", "macchiato"};
    private String[] universities = {"bilkent", "odtu", "bogazici", "koc", "sabanci", "galatasaray", "itu", "hacettepe",
        "gazi", "yeditepe", "bahcesehir", "tobb", "ege", "cukurova", "hitit", "baskent", "ytu", "istanbul", "capa",
        "ozyegin", "marmara", "medipol", "mef", "ankara"};
    private String[] celebrities = {"zendaya", "madonna", "eminem", "rihanna", "drake", "shakira", "adele", "pink",
        "usher", "jayz", "tarkan", "teoman", "karsu", "weeknd", "yalin", "britney", "selena", "messi", "ronaldo",
        "alex", "hagi", "kobe", "lebron", "curry", "durant", "jordan", "erdogan", "kilicdaroglu", "imamoglu", "carlsen",
        "nadal", "djokovic", "bolt", "phelps", "kasparov", "sharapova", "williams", "hadise"};
    private String[] tvShows = { "friends","merlin","drwho","selena","elite","office","crown","you","seinfeld","suits","outlander","snowpiecer",
        "sherlock","vikings","ozark","glee","community"};
        //constructor   
    public Hangman(int gameMode)
    {   
        chooseGameMode(gameMode);
        maxAllowedIncorrectTries = 6;
        allLetters = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        chooseSecretWord();
        for(int i = 0; i < secretWord.length(); i++)
        {
            knownSoFar.append("*");
        }
    }
    //methods
    private void chooseGameMode(int num)
    {
        if(num == 1)
        {
            allWords = tvCharacters;
        }
        else if(num == 2)
        {
            allWords = coffeeNames;
        }
        else if(num == 3)
        {
            allWords = universities;
        }
        else if(num == 4)
        {
            allWords = celebrities;
        }
        else if(num == 5)
        {
            allWords = tvShows;
        }
        else{
            System.out.println("Invalid game mode. Please enter a number between 1-4");
        }
    }
    private void chooseSecretWord()
    {
        Random rand = new Random();
        int allWordsLength = allWords.length;
        int randomNumber = rand.nextInt(allWordsLength);
        String secretWordString = allWords[randomNumber];
        secretWord.append(secretWordString);
    }
    // getters
    public String getAllLetters()
    {
        return allLetters.toString();
    }
    public String getSecretWord()
    {
        return this.secretWord.toString();
    }
    public String getUsedLetters()
    {
        return this.usedLetters.toString();
    }
    public int getNumOfIncorrectTries()
    {
        return this.numberOfIncorrectTries;
    }
    public String getKnownSoFar()
    {
        return this.knownSoFar.toString();
    }
    public void setKnownSoFar(String newWord)
    {
        this.knownSoFar.setLength(0);
        knownSoFar.append(newWord);
    }
    //input check
    public int tryThis(char letter)
    {
        int number = 0;
        String secretString = secretWord.toString();
        for(int i = 0; i < secretString.length(); i++)
        {
            if(secretString.charAt(i) == letter)
            {
                number ++;
                String knownSoFarString = knownSoFar.toString();
                if(i != secretString.length() - 1)
                {
                    knownSoFarString = knownSoFarString.substring(0, i) + letter + knownSoFarString.substring(i+1, secretString.length());
                }
                else 
                {
                    knownSoFarString = knownSoFarString.substring(0, i) + letter;
                }
                knownSoFar.setLength(0);
                knownSoFar.append(knownSoFarString);

            }
            else if(i == secretString.length() - 1 && number == 0)
            {
                numberOfIncorrectTries++;
            }
        }
        usedLetters.append(letter);
        return number;
    }
    //game conditions
    public boolean isGameOver()
    {
        if (knownSoFar.toString().equals(secretWord.toString()) || hasLost())
        {
            return true;
        }
        return false;
    }

    public boolean hasLost()
    {
        if(numberOfIncorrectTries == maxAllowedIncorrectTries)
        {
            return true;
        }
        return false;
    }
}