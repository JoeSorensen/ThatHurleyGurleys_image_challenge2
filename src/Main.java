import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> gInput = new ArrayList<>();
    public static ArrayList<Integer> gOutput = new ArrayList<>();
    public static void main(String [] args) {
        Image image1 = new Image("scrambled1.png");
        Image image2 = new Image("scrambled2.png");
        Image out = new Image(image1.getWidth(), image2.getHeight());
        for(int i = 0; i < image1.getHeight(); i++) {
            for(int j = 0; j < image2.getWidth(); j++) {
                Pixel pix1 = image1.getPixel(i, j);
                Pixel pix2 = image2.getPixel(i, j);
                Pixel outpix = image1.getPixel(i, j);

                out.setPixel(i, j, pix1.red^pix2.red, pix1.green^pix2.green, pix1.blue^pix2.blue);
                System.out.println(i+" "+j+" "+outpix.toString());
            }
        }
        System.out.println(image1.getPixel(0,0));
        System.out.println(image2.getPixel(0,0));

        out.write("output.png");
        gInput.add(0);
        gInput.add(1);
        gOutput.add(0);
        gOutput.add(1);
        System.out.println("Final: " + g(78));
    }

    public static int g(int x) {
        if(gInput.contains(x)) {
            return gOutput.get(gInput.indexOf(x));
        } else {
            int i = g(x - 1) + g(x - 2) + x;
            gInput.add(x);
            gOutput.add(i);
            System.out.println("Input: " + gInput);
            System.out.println("Output: " + gOutput);
            return i;
        }
    }
}
