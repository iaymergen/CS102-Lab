import java.awt.*;

public class Tank extends EnemyVehicle
{

    public Tank(int minX, int maxX, int y) 
    {
        super(minX, maxX, y);
    }

    @Override
    public void move() 
    {    
        super.move();
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
        damage = damage - 10;
        super.takeDamage(damage);   
    }

    @Override
    public String getType() {
        return "Tank";
    }
    public String toString()
    {
        return "Tank at x:" + this.x + " y:" + this.y + "\n Speed: " + this.speed + "\n Remaining lives: " + this.lives;
    }
    
}
