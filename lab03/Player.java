import java.util.ArrayList;

public class Player 
{
    final double BOMB_RADIUS = 2.0;
    final double DAMAGE = 50.0;

    Player()
    {}    
    public void attack(int x, int y, ArrayList<EnemyVehicle>enemies)
    {
        for(int i = 0; i < enemies.size(); i++)
        {
            int eX = enemies.get(i).x;
            int eY = enemies.get(i).y;
            if((eX - x) * (eX - x) + (eY - y) * (eY - y) < BOMB_RADIUS * BOMB_RADIUS)
            {
                enemies.get(i).takeDamage(DAMAGE);
                enemies.get(i).isDestroyed();
            }
        }
    } 
}
