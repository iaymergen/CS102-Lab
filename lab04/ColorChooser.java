import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.*;


public class ColorChooser extends JPanel
{
    StickMan stck;
    JColorChooser colorChoose;
    ColorChooser(StickMan stck)
    {
        this.stck = stck;
        JButton colorButton  = new JButton("Choose Color");
        colorButton.addActionListener(new ColorListener());
        this.add(colorButton);
    }
    class ColorListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
           colorChoose = new JColorChooser();
           Color c = colorChoose.showDialog(null, "Choose A Color", Color.PINK);
           stck.setColor(c);
           repaint();
           
        }
    }
}
