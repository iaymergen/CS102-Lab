import java.awt.*;

public class Helicopter extends EnemyVehicle
{

    public Helicopter(int minX, int maxX, int y) 
    {
        super(minX, maxX, y);
    }

    @Override
    public void move() 
    {
        this.speed++;
        this.y = this. y + this.speed;
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
        return super.isDestroyed();
    }

    @Override
    public void takeDamage(double damage) 
    {
        super.takeDamage(damage);   
    }

    @Override
    public String getType() 
    {
        return "Helicopter";
    }
    public String toString()
    {
        return "Helicopter at x:" + this.x + " y:" + this.y  + "\n Speed: " + this.speed + "\n Remaining lives: " + this.lives;
    }
    
}
