/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

/**
 *
 * @author acer
 */
public class CustomSliderUI extends BasicSliderUI {
    private Image thumbImage;
    public CustomSliderUI(JSlider slider) {
        super(slider);
        // Load hình ảnh từ tệp hình ảnh trong thư mục resources
        
        thumbImage = new ImageIcon("Assets/chicken3.gif").getImage();
    }

    @Override
    protected Dimension getThumbSize() {
       return new Dimension(thumbImage.getWidth(null), thumbImage.getHeight(null));
    }

    @Override
    public void paintThumb(Graphics g) {
          Graphics2D g2d = (Graphics2D) g;
        Rectangle thumbBounds = thumbRect;

        int x = thumbBounds.x;
        int y = thumbBounds.y;

        g2d.drawImage(thumbImage, x, y, null);
    }

    @Override
    public void paintTrack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle trackBounds = trackRect;
        Rectangle2D track = new Rectangle2D.Double(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        g2d.setColor(Color.GRAY);  // Màu của thanh trượt
        g2d.fill(track);
    }

    @Override
    public void paintTicks(Graphics g) {
        // Bạn có thể tùy chỉnh việc vẽ các dấu chia trên thanh trượt ở đây
        super.paintTicks(g);
    }

    @Override
    public void paintLabels(Graphics g) {
        // Bạn có thể tùy chỉnh việc vẽ các nhãn trên thanh trượt ở đây
        super.paintLabels(g);
    }
}
