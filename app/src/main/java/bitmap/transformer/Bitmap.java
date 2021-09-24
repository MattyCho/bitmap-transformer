package bitmap.transformer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {

    // 3 arguments:
    private File input;
    private File output;
    private String name;

    // Bitmap Constructor
    public Bitmap (String input, String output, String name) {
        this.input = new File(input);
        this.output = new File(output);
        this.name = name;
    }

    public void blackAndWhite() {
        try {
            BufferedImage bmpFile = ImageIO.read(this.input);
            for (int i = 0; i < bmpFile.getWidth(); i++) {
                for (int j = 0; j < bmpFile.getHeight(); j++) {
                    Color bmpColor = new Color(bmpFile.getRGB(i,j));
                    int r = (int)(bmpColor.getRed() * 0.3);
                    int g = (int)(bmpColor.getGreen() * 0.6);
                    int b = (int)(bmpColor.getBlue() * 0.1);
                    int sum = r + g + b;
                    Color newBmp = new Color(sum, sum, sum);
                    bmpFile.setRGB(i, j, newBmp.getRGB());
                }
            }
            saveNewBmp(bmpFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBorder() {
        try {
            int r = 0;
            int g = 120;
            int b = 255;
            BufferedImage bmpFile = ImageIO.read(this.input);
            for (int i = 0; i < bmpFile.getWidth(); i++) {
                for (int j = 0; j < bmpFile.getHeight(); j++) {
                    if (j < 5) {
                        Color newBmp = new Color(r, g, b);
                        bmpFile.setRGB(i, j, newBmp.getRGB());
                    }
                    if (j > bmpFile.getHeight() - 5) {
                        Color newBmp = new Color(r, g, b);
                        bmpFile.setRGB(i, j, newBmp.getRGB());
                    }
                    if (i < 5) {
                        Color newBmp = new Color(r, g, b);
                        bmpFile.setRGB(i, j, newBmp.getRGB());
                    }
                    if (i > bmpFile.getWidth() - 5) {
                        Color newBmp = new Color(r, g, b);
                        bmpFile.setRGB(i, j, newBmp.getRGB());
                    }
                }
            }
            saveNewBmp(bmpFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flipVertical() {
        try {
            BufferedImage bmpFile = ImageIO.read(this.input);

            int width = bmpFile.getWidth();
            int height = bmpFile.getHeight();

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height/2; j++) {
                    int normalColor = bmpFile.getRGB(i, j);
                    int flipColor = bmpFile.getRGB(i, height - 1 - j);
                    bmpFile.setRGB(i, j, flipColor);
                    bmpFile.setRGB(i, height - 1 - j, normalColor);
                }
            }
            saveNewBmp(bmpFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveNewBmp(BufferedImage buff) {
        try {
            File outputFilePath = new File(this.output + "/" + this.name);
            ImageIO.write(buff, "bmp", outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
