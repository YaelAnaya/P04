/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yael.ao.p04;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author yaela
 */
public class RoundedPanel extends JPanel{
    
    protected int radius;
    
    public RoundedPanel() {
        setOpaque(false);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
  
    @Override
    protected void paintComponent(Graphics g) {
        
        

        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(getBackground());

        graphics2D.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
        graphics2D.dispose();
        super.paintComponent(g);

    }

}
