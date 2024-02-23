import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
public class ButtonPanel extends JPanel
{
    StickMan stck;
    public ButtonPanel(StickMan stck)
    {
        this.stck = stck;
        JButton moveLeft = new JButton("Move Left");
        JButton moveRight = new JButton("Move Right");
        JButton stopMan = new JButton("Stop Man");
        moveLeft.addActionListener(new ButtonLeft());
        moveRight.addActionListener(new ButtonRight());
        stopMan.addActionListener(new ButtonStop());
        this.add(moveLeft);
        this.add(moveRight);
        this.add(stopMan);
        
        
    }
    class ButtonLeft implements ActionListener
    {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                stck.moveX = -7;
                System.out.println("Moved Left");
            }
    }   
    class ButtonRight implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            stck.moveX = 7;
            System.out.println("Moved Right");
        }
    }
    class ButtonStop implements ActionListener
    {
        @Override 
        public void actionPerformed(ActionEvent e)
        {
            stck.moveX = 0;
            System.out.println("Man stopped");
        }
    }
    
   
}
