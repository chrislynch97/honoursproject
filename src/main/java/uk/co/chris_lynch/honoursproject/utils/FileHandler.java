package uk.co.chris_lynch.honoursproject.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class FileHandler {

  /**
   * Load {@link java.awt.image.BufferedImage} from resources
   * with desired filename.
   * @param filename name of image to load
   * @return    A {@link java.awt.image.BufferedImage} object or
   *            {@code null} if it could not be found.
   */
  public static BufferedImage loadBufferedImage(final String filename) {
    try {
      return ImageIO.read(FileHandler.class.getResource("/".concat(filename)));
    } catch ( IOException e ) {
      e.printStackTrace();
      return null;
    }
  }

}
