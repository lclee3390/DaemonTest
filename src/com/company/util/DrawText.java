package com.company.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DrawText {

    private static final String IMAGE_TYPE="png";
    private static final String IMAGE_FILEPATH = "C:/Users/Lee/Desktop/" + System.currentTimeMillis() + ".png";

    public void create() {
        DrawText code = new DrawText();
        BufferedImage bufferImage = code.getImage();
        code.saveImage(bufferImage, IMAGE_TYPE, IMAGE_FILEPATH);
    }

    public BufferedImage getImage() {
        int width = 320;
        int height = 200;
        int degree = 0;
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Color background = new Color(255, 255, 255);
        g.setColor(background);
        g.fillRect(0, 0, width, height);

        Color textColor = new Color(0, 0, 0);
        g.setColor(textColor);

        //"MS PGothic" font
        String text = "Hello font!";
        Font textFont = new Font("DejaVu Sans", Font.PLAIN, 22);
        g.setFont(textFont);
        Graphics2D g2d_1 = (Graphics2D) g.create();
        g2d_1.translate(20, 20);
        g2d_1.drawString(text, 0, 0);

        g.dispose();
        return image;
    }

    public void saveImage(BufferedImage image, String format, String filePath) {
        try {
            ImageIO.write(image, format, new File(filePath));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
