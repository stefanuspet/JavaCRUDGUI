package component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int arc = 20; // Adjust the arc value to control the roundness
        
        g2.setColor(getBackground());
        g2.fillRoundRect(10, 10, getWidth(), getHeight(), arc, arc);
        
        g2.dispose();
    }
    
}

