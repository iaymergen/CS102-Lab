
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.Dimension;

public class StickMan extends JPanel
{
    private int baseX, baseY;
    private Color color;
    int size;
    int moveX;
    private Timer timer;
    Boolean b1,b2,b3,b4,b5;

    StickMan(int baseX, int baseY, Color color, int size)
    {
        this.baseX = baseX;
        this.baseY = baseY;
        this.color = color;
        this.size = size; 
        this.moveX = 7;
        timer = new Timer(10, new ReboundListener());
        timer.start();

    }
    private class ReboundListener implements ActionListener
    {
        @Override
        
            public void actionPerformed(ActionEvent event)
            {
                baseX += moveX;
                if(baseX <= 0 || baseX >= 400)
                {
                 moveX = moveX * -1;
                }
                repaint();
            }
    }

    public void setX(int x)
    {
        this.baseX = x;
    }
    public void setY(int y)
    {
        this.baseY = y;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(color);
        g.drawString("Merhaba ben dans eden Ayca", baseX + 30, baseY -160);
        g.drawArc(baseX - 3, baseY - 107 , 9, 9, -180, 180);
        if(b1)
        {
            g.drawOval(baseX - 25, baseY - 140, 50, 50);
            g.drawOval(baseX - 15, baseY - 120, 5, 5);
            g.drawOval(baseX + 12, baseY -120, 5, 5);
            g.drawOval(baseX, baseY - 110, 3, 3);
        }
        if(b2)
        {
            g.drawLine(baseX, baseY - 90, baseX, baseY - 20);
        }
        if(b3)
        {
            g.drawLine(baseX -30, baseY - 60, baseX + 30, baseY - 60);
        }
        if(b4)
        {
            g.drawLine(baseX, baseY -20, baseX - 30, baseY);
            g.drawLine(baseX, baseY - 20, baseX + 30, baseY);
        }
        
        g.drawString("Merhaba ben dans eden Ayca", baseX + 30, baseY -160);
        
    }

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StickMan stck = new StickMan(250, 250, Color.RED, 10);
        stck.setPreferredSize(new Dimension(100,100));
        frame.add(stck, BorderLayout.CENTER);
        ButtonPanel buttonPanel = new ButtonPanel(stck);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        ColorChooser colorChooser = new ColorChooser(stck);
        frame.add(colorChooser, BorderLayout.NORTH);
        BodyParts bodyParts = new BodyParts(stck);
        frame.add(bodyParts, BorderLayout.EAST);
        frame.setVisible(true);
        
    }

    
}
