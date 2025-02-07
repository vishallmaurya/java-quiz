package utils;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SetImage extends JPanel {
    private Image backgroundImage;

    public SetImage(String imagePath, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        if (icon.getImageLoadStatus() == java.awt.MediaTracker.ERRORED) {
            System.err.println("Error loading image: " + imagePath);
            return;
        }
        backgroundImage = icon.getImage();
        setBounds(x, y, width, height); // Ensuring the panel has correct dimensions
        setOpaque(false); // Make sure transparency is maintained
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
