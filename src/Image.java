import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    private BufferedImage image;

    public Image(String filename) {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.out.println("Couldn't read that file, you sure it exists?");
        }
    }

    public Image(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void setPixel(int x, int y, int red, int green, int blue) {
        int rgb = rgbToInt(red, green, blue);
        image.setRGB(x, y, rgb);
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public Pixel getPixel(int x, int y) {
        int rgb = image.getRGB(x, y);
        int red = (rgb & 0xFF0000) >> 16;
        int green = (rgb & 0x00FF00) >> 8;
        int blue = rgb & 0x0000FF;
        return new Pixel(red, green, blue);
    }

    public void write(String filename) {
        try {
            ImageIO.write(image, "png", new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int rgbToInt(int red, int green, int blue) {
        return (red << 16) + (green << 8) + blue;
    }
}

