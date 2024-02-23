import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game implements Difficulty
{
    final int STARTING_DISTANCE = 20;
    int start = 0;
    ArrayList<EnemyVehicle>enemies = new ArrayList<EnemyVehicle>();
    Player player;
    int score = 0;
    int difficulty = 0;
    int destroyedOnes;
    int passedOnes;
    int MAX_NO_OF_PASSING_ENEMIES = 5;
    

    Game(int difficulty)
    {
        this.difficulty = difficulty;
        setDifficulty(difficulty);
        this.player = new Player();
        if(difficulty == 1)
        {
            for(int i = 0; i < 2; i++)
            {
                EnemyVehicle ev = getNewRandomEnemyVehicle();
                this.enemies.add(ev);
            }
        }
        if(difficulty == 2)
        {
            for(int i = 0; i < 4; i++)
            {
                EnemyVehicle ev = getNewRandomEnemyVehicle();
                this.enemies.add(ev);
            }
        }
        if(difficulty == 3)
        {
            for(int i = 0; i < 6; i++)
            {
                EnemyVehicle ev = getNewRandomEnemyVehicle();
                this.enemies.add(ev);
            }
        }
    }
    ArrayList<EnemyVehicle> getEnemies()
    {
        return this.enemies;
    }
    void printGameState()
    {
        int height = STARTING_DISTANCE;
        int width = 5 * getDifficulty();

        System.out.print("   ");
        for (int j = 0; j < width; j++)
            System.out.printf("%3d ", j);
        System.out.println();

        System.out.print("   ");
        for (int j = 0; j < width; j++)
            System.out.print(" ___");
        System.out.println();
        for (int i = height; i >= 0; i--)
        {
            System.out.printf("%2d ", i);
            for (int j = 0; j < width; j++)
            {
                System.out.print("|");
                int enemyCountOnThisPosition = 0;
                for (EnemyVehicle e :
                        getEnemies()) {
                    if (e.getLocation().x == j && e.getLocation().y == i)
                        enemyCountOnThisPosition++;
                }
                System.out.print(enemyCountOnThisPosition == 0 ? "___" : "_" + enemyCountOnThisPosition + "_");
            }
            System.out.println("|");
        }
        System.out.println("Passed enemies: " + this.passedOnes);
        System.out.println("Destroyed enemies: " + this.destroyedOnes);
        for(int i = 0; i < enemies.size(); i++)
        {
            System.out.println(enemies.get(i));
        }
        

    }
    void enemiesTurn()
    {
        for(int i = 0; i < enemies.size(); i++)
        {
            if(enemies.get(i).isDestroyed())
            {
                enemies.set(i, getNewRandomEnemyVehicle());
                destroyedOnes++;
            }
            enemies.get(i).move();
            if(enemies.get(i).y > 20)
            {
                enemies.set(i, getNewRandomEnemyVehicle());
                passedOnes++;
            }
            
        }

    }
    
    @Override
    public void setDifficulty(int difficulty) 
    {
        String difStr;
        if(difficulty == 1)
        {
            difStr = "Easy";
        }
        if(difficulty == 2)
        {
            difStr = "Medium";
        }
        if(difficulty == 3)
        {
            difStr = "Hard";
        }
    }

    @Override
    public int getDifficulty() 
    {
        return this.difficulty;
    }
    public void play()
    {
        Scanner scan = new Scanner(System.in);
        do
        {
        printGameState();
        System.out.println("Plase input cordinates: ");
        int x = scan.nextInt();
        int y = scan.nextInt();
       
        this.player.attack(x,y,enemies);
        enemiesTurn();
        }while(passedOnes <= MAX_NO_OF_PASSING_ENEMIES);
        
    }
    private EnemyVehicle getNewRandomEnemyVehicle()
    {
        Random rand = new Random();
        int pick = rand.nextInt(2);
        if(pick == 0)
        {
            if(difficulty == 1)
            {
                Tank tank = new Tank(0, 5, start);
                return tank;
            }
            if(difficulty == 2)
            {
                Tank tank = new Tank(0, 10, start);
 
                return tank;
            }
            else
            {
                Tank tank = new Tank(0, 15, start);
              
                return tank;
            } 
        }
        else
        {
            if(difficulty == 1)
            {
                Helicopter heli = new Helicopter(0, 5, start);
             
                return heli;
            }
            if(difficulty == 2)
            {
                Helicopter heli = new Helicopter(0, 10, start);
              
                return heli;
            }
            else
            {
                Helicopter heli = new Helicopter(0, 15, start);
                
                return heli;
            } 

        }
        
    }
}
