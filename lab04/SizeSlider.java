import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SizeSlider extends JPanel
{
    StickMan stck;
    JSlider sizeSlider = new JSlider();
    SizeSlider(StickMan stck)
    {
        this.stck = stck;
        sizeSlider.addChangeListener(new sizeListener());
        this.add(sizeSlider);
    
    }
    class sizeListener implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent e) 
        {
            int s = sizeSlider.getValue();
            stck.size = s;
            repaint();

        }
    }
}
