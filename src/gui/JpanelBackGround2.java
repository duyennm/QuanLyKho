/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Mao
 */
public class JpanelBackGround2 extends JPanel {

    String url;

    public JpanelBackGround2(String url) {
        this.url = url;
    }

    @Override
    public void paintComponent(Graphics g) {
        Image img = new ImageIcon(getClass().getResource(url)).getImage();;
        g.drawImage(img, 0, 0, null);

    }
}
