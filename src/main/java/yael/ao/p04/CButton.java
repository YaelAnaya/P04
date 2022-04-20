/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yael.ao.p04;

import com.formdev.flatlaf.ui.FlatRoundBorder;
import com.formdev.flatlaf.ui.FlatTableCellBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author yaela
 */
public class CButton extends JLabel {
    
    private ImageIcon baseImage;
    private ImageIcon hoverImage;

 
    public CButton() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(true);
        this.setText(" ");
        setIcon(baseImage);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               setIcon(hoverImage);
               repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(baseImage);
                repaint();
            }
        });
    }

    public void setBaseImage(ImageIcon baseImage) {
        this.baseImage = baseImage;
    }

    public void setHoverImage(ImageIcon hoverImage) {
        this.hoverImage = hoverImage;
    }

    @Override
    protected void paintComponent(Graphics g) {

        var graphics2D = (Graphics2D) g.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.dispose();
        super.paintComponent(g);

    }
    
    @Override
    public JToolTip createToolTip() {
        var toolTip = super.createToolTip();
        putClientProperty("Popup.dropShadowPainted", Boolean.FALSE);
        toolTip.setBorder(new FlatRoundBorder());
        toolTip.setFont(new Font(this.getFont().getName(), 1, 12));
        toolTip.setTipText(this.getToolTipText());
        return toolTip;
    }
    

}
