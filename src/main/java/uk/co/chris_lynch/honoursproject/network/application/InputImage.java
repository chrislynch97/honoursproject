package uk.co.chris_lynch.honoursproject.network.application;

import uk.co.chris_lynch.honoursproject.utils.FileHandler;

import java.awt.image.BufferedImage;

public class InputImage {

  private int[][] pixels;
  private BufferedImage image;

  public InputImage(final String filename) {
    this.image = FileHandler.loadBufferedImage((filename));
    initPixels();
  }

  private void initPixels() {
    int width = image.getWidth();
    int height = image.getHeight();

    pixels = new int[width][height];

    for (int i = 0; i < width; i++)
      for (int j = 0; j < height; j++)
        pixels[i][j] = image.getRGB(i,j);
  }

  int getWidth() {
    return pixels.length;
  }

  int getHeight() {
    return pixels[0].length;
  }

  int getPixel(final int x, final int y) {
    return pixels[x][y];
  }
}