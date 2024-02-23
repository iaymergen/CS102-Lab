import java.awt.*;
import java.util.Random;

public abstract class EnemyVehicle implements Movable, Destructible
{
    final int BASE_SPEED = 3;
    int speed = BASE_SPEED;
    int minX , maxX, y,x;   
    double damage;
    int lives = 150;
    boolean destroyed = false;
    public EnemyVehicle(int minX, int maxX, int y)
    {   
        Random rand = new Random();
        this.minX = minX;
        this.maxX = maxX;
        this.x = rand.nextInt(maxX);
        this.y = y;
    }
    public int getDistanceToBorder()
    {
        return this.y;
    }
    public abstract String getType();
    
    @Override
    public void move() 
    {
        this.y = this.y + this.speed;
    }
    @Override
    public Point getLocation() 
    {
        Point p = new Point(this.x, this.y);
        return p;
    }
    @Override
    public boolean isDestroyed() 
    {
        return (lives <= 0);
    }

    @Override
    public void takeDamage(double damage) 
    {
        this.lives = (int) (lives - damage);   
    }

}
