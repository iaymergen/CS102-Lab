import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;


public class BodyParts extends JPanel
{
    StickMan stck;
   Checkbox[] bodyParts = new Checkbox[4];

    BodyParts(StickMan stck)
    {
        colorListener lc = new colorListener();
        this.stck = stck;
        Checkbox c1 = new Checkbox("Head");
        c1.addItemListener(lc);
        bodyParts[0] = c1;
        this.add(c1);
        Checkbox c2 = new Checkbox("Body");
        bodyParts[1] = c2;
        c2.addItemListener(lc);
        this.add(c2);
        Checkbox c3 = new Checkbox("Arms");
        bodyParts[2] = c3;
        c3.addItemListener(lc);
        this.add(c3);
        Checkbox c4 = new Checkbox("Legs");
        bodyParts[3] = c4;
        c4.addItemListener(lc);
        this.add(c4);
      
    }
    class colorListener implements ItemListener
    {
        @Override
        
            public void itemStateChanged(ItemEvent e)
            {
                if(bodyParts[0].getState())
                {
                    stck.b1= true;
                    repaint();
                }
                else
                {
                    stck.b1 = false;
                    repaint();
                }
                if(bodyParts[1].getState())
                {
                    stck.b2= true;
                    repaint();
                }
                else
                {
                    stck.b2 = false;
                    repaint();
                }
                if(bodyParts[2].getState())
                {
                    stck.b3= true;
                    repaint();
                }
                else
                {
                    stck.b3 = false;
                    repaint();
                }
                if(bodyParts[3].getState())
                {
                    stck.b4= true;
                    repaint();
                }
                else
                {
                    stck.b4 = false;
                    repaint();
                }
            }
        
    }
    
}
