package uk.co.chris_lynch.honoursproject.network.application;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class InputImage {

  private int[][] pixels;
  private BufferedImage image;

  public InputImage(final String filename) {
    try {
      image = ImageIO.read(getClass().getResource("/".concat(filename)));
    } catch ( IOException e ) {
      e.printStackTrace();
      return;
    }
    initPixels();
  }

  private void initPixels() {
    int width = image.getWidth();
    int height = image.getHeight();
    pixels = new int[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        pixels[i][j] = image.getRGB(i,j);
      }
    }
  }

  int getWidth() {
    return pixels.length;
  }

  int getHeight() {
    return pixels[0].length;
  }

  int getPixel(final int i, final int j) {
    return pixels[i][j];
  }
}