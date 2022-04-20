/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yael.ao.p04;

import com.formdev.flatlaf.ui.FlatRoundBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToolTip;

/**
 *
 * @author yaela
 */
public class CJLabel extends JLabel {

    public CJLabel() {
        super();
        createToolTip();
    }

    public void setIcon(Image image) {
        super.setIcon(new ImageIcon(image));
    }

    @Override
    protected void paintComponent(Graphics g) {

        var graphics2D = (Graphics2D) g.create();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(true);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.dispose();

        super.paintComponent(g);

    }

    @Override
    public JToolTip createToolTip() {
        var toolTip = super.createToolTip();
        putClientProperty("Popup.dropShadowPainted", Boolean.FALSE);
        toolTip.setBorder(null);
        toolTip.setBackground(Color.decode("#414141"));
        toolTip.setForeground(Color.decode("#FDFDFD"));
        toolTip.setFont(new Font(this.getFont().getName(), 1, 12));
        toolTip.setTipText(this.getToolTipText());
        return toolTip;
    }

}
